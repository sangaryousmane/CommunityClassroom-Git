# coding=utf-8
import dns
import sys
sys.setrecursionlimit(10000)
import string
 
import urllib
from urllib.request import urlopen
import multiprocessing
from multiprocessing import Queue
from multiprocessing import RLock
import gevent
from gevent import monkey
import dns.resolver
from bs4 import BeautifulSoup
# 一定不能让猴子补丁覆盖掉线程thread类，不然程序不会运行。参考 http://xiaorui.cc/2016/04/27/%e6%ba%90%e7%a0%81%e5%88%86%e6%9e%90%e4%b9%8bgevent-monkey-patch_all%e5%ae%9e%e7%8e%b0%e5%8e%9f%e7%90%86/
monkey.patch_all(thread=False)
#socket.setdefaulttimeout(8)
 
domainqueue = Queue()
Message = Queue()
Mesdict = {}
usefulIp = Queue()
uselessIP = Queue()
 
class subsearch(object):
    def __init__(self):
        self.set = set()
        net = self._creatdomain()
        for i in range(100000):
            a = net.next()
            self.set.add('www.' + a + '.com')
        for i in self.set:
            domainqueue.put_nowait(i)
 
    def _creatdomain(self):
        ergodicword = ['', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
        for word in string.lowercase:
            ergodicword.append(word)  # 生成26个英文字母并添加进去
        for i in ergodicword:
            for j in ergodicword:
                for k in ergodicword:
                    for l in ergodicword:
                        for m in ergodicword:
                            yield i + j + k + l + m
 
 
class subvisit(object):
    def __init__(self, DNSSERVER, headers):
        self.dnsserver = DNSSERVER
        self.run()
        self.headers = headers
 
    def start(self, i):
        self.id = i
        self.work()
 
    def work(self):
        resolver1 = dns.resolver.Resolver()
        resolver1.lifetime = resolver1.timeout = 5.0
        resolver1.nameservers = [self.dnsserver]
        A = ''
        while not domainqueue.empty():
            try:
                url = domainqueue.get()
            except BaseException:
                break
            try:
                A = resolver1.query(url)
            except dns.resolver.NXDOMAIN as xxx_todo_changeme:
                dns.resolver.Timeout = xxx_todo_changeme
                continue
            except dns.exception.DNSException:
                continue
            if A:
                headers['Host'] = url
                try:
                    codenum = urlopen('http://' + url).getcode()
                    if codenum == 200 or codenum == 304:
                        pass
                    else:
                        continue
                    req = urllib.Request('http://' + url, headers=headers)
                    res = urllib.urlopen(
                        req, timeout=10)  # urllib2的get方法访问url
                    response = res.read()  # 获取正文
                    res.close()
                    del res
                    soup = BeautifulSoup(response)
                    title = soup.title
                except Exception as e:
                    #title = "Not Found"
                    continue
                if title:
                    title = str(title)[7:-8]
                    lock.acquire()
                    print(str(url).ljust(13),str(A[0].address).ljust(15),title)
                    lock.release()
                #Message.put_nowait((url, A[0].address,title))
                # usefulIp.put_nowait(url)
 
    def run(self):
        try:
            threads = [gevent.spawn(self.start, i) for i in range(50)]
            gevent.joinall(threads)
        except KeyboardInterrupt as e:
            pass
 
 
if __name__ == '__main__':
    lock = RLock()
    DnsServer = ['114.114.114.114', '114.114.115.115', '223.5.5.5',
                 '223.6.6.6', '112.124.47.27', '114.215.126.16']
    headers = {
        'Host': '',
        'User-Agent': 'Mozilla / 5.0(X11;Ubuntu;Linuxx86_64;rv:55.0) Gecko / 20100101Firefox / 55.0',
        'Accept': 'text / html, application / xhtml + xml, application / xml;q = 0.9, * / *;q = 0.8',
        'Accept-Language': 'zh - CN, zh;q = 0.8, en - US;q = 0.5, en;q = 0.3',
        'Accept-Encoding': 'gzip, deflate, br',
        'Connection': 'keep - alive',
    }
    b = subsearch()
    pool = multiprocessing.Pool(processes=6)
    result = []
    for i in range(6):
        result.append(pool.apply_async(subvisit, args=(DnsServer[i], headers)))
    pool.close()
    pool.join()