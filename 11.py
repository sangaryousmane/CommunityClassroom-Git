#!coding=utf-8
import sys
import os
#文件名称替换函数
def replace_filename(file_path, oldPartName, newPartName):#file_path为文件夹路径；oldPartName需要修改的部分字符；newPartName修改后的字符
    for root, dirs, files in os.walk(file_path): #获取文档内所有文件
        for file_name in files: #取出文件夹下各文件名（包括子文件中的）
            if file_name.endswith('.txt'):  #选出要修改的文件类型；此句取消后就不对类型做判断
                if oldPartName in file_name:  #含有要替换的部分文字
                    os.rename(os.path.join(root, file_name), os.path.join(root, file_name.replace(oldPartName, newPartName))) #进行部分替换
                    print('new file name is {0}'.format(file_name.replace(oldPartName, newPartName))) #输出替换后的名字

replace_filename(r'F:\\movie, 'a', 'b')