from mpl_toolkits.basemap import Basemap
import matplotlib.pyplot as plt  # 化图
from matplotlib.patches import Polygon  # 上色
import time

# 字典代替邻接矩阵
str = {'河北省': ['内蒙古自治区', '山西省', '山东省', '北京市', '天津市', '辽宁省'],
       '山东省': ['河北省', '天津市', '山西省', '湖南省', '江苏省'],
       '安徽省': ['山东省', '湖南省', '湖北省', '江西省', '浙江省', '江苏省'],
       '江苏省': ['山东省', '安徽省', '上海市', '浙江省'],
       '上海市': ['江苏省', '浙江省'],
       '浙江省': ['上海市', '安徽省', '江西省', '福建省', '江苏省'],
       '江西省': ['安徽省', '湖北省', '湖南省', '广东省', '福建省', '浙江省'],
       '福建省': ['浙江省', '江西省', '广东省'],
       '黑龙江省': ['内蒙古自治区', '吉林省'],
       '吉林省': ['内蒙古自治区', '黑龙江省'],
       '辽宁省': ['内蒙古自治区', '吉林省', '河北省'],
       '北京市': ['河北省', '天津市'],
       '天津市': ['河北省', '北京市'],
       '海南省': [],
       '台湾省': [],
       '澳门特别行政区': [],
       '香港特别行政区': [],
       '新疆维吾尔自治区': ['西藏自治区', '青海省', '甘肃省'],
       '西藏自治区': ['新疆维吾尔自治区', '青海省', '四川省', '云南省'],
       '青海省': ['西藏自治区', '新疆维吾尔自治区', '甘肃省', '四川省'],
       '甘肃省': ['新疆维吾尔自治区', '青海省', '四川省', '内蒙古自治区', '陕西省', '宁夏回族自治区'],
       '四川省': ['西藏自治区', '青海省', '甘肃省', '陕西省', '重庆市', '贵州省', '云南省'],
       '云南省': ['四川省', '贵州省', '广西壮族自治区'],
       '内蒙古自治区': ['甘肃省', '宁夏回族自治区', '陕西省', '山西省', '河北省', '吉林省', '辽宁省', '黑龙江省'],
       '宁夏回族自治区': ['陕西省', '内蒙古自治区', '甘肃省'],
       '陕西省': ['宁夏回族自治区', '甘肃省', '四川省', '内蒙古自治区', '重庆市', '湖北省', '湖南省', '山西省'],
       '重庆市': ['陕西省', '四川省', '贵州省', '湖南省', '湖北省'],
       '贵州省': ['重庆市', '四川省', '云南省', '广西壮族自治区', '湖南省'],
       '广西壮族自治区': ['云南省', '贵州省', '湖南省', '广东省'],
       '山西省': ['内蒙古自治区', '陕西省', '河南省', '山东省', '河北省'],
       '河南省': ['山西省', '陕西省', '湖北省', '安徽省', '山东省'],
       '湖北省': ['河南省', '重庆市', '陕西省', '湖南省', '江西省', '安徽省'],
       '湖南省': ['湖北省', '重庆市', '贵州省', '广西壮族自治区', '广东省', '江西省', '安徽省'],
       '广东省': ['湖南省', '江西省', '福建省', '广西壮族自治区']}

# 画中国地图
m = Basemap(llcrnrlon=77, llcrnrlat=14, urcrnrlon=140, urcrnrlat=51, projection='lcc', lat_1=33, lat_2=45, lon_0=100)
m.readshapefile('shapefiles/china', 'china', drawbounds=True)

# 得到中国的各个省，使用set不会重复
locatName = set()
for i in m.china_info:
    name = i['OWNER']
    locatName.add(name.replace("\x00", ""))

# 将set转换为list方便处理
nameList = list(locatName)
print(nameList)
print(len(nameList))

# 初始化每个省的颜色为0
nameDict = dict()
for i in nameList:
    nameDict[i] = 0
print(nameDict)
print(len(nameDict))


# 得到 s 省相邻地区的颜色列表
def getColorList(s):
    colorList = []
    for i in str[s]:
        colorList.append(nameDict[i])
    return colorList


#  给 seg 地区 画 k 颜色
ax = plt.gca()


def pColor(seg, k):
    colorStr = ""
    if k == 1:
        colorStr = "r"
    elif k == 2:
        colorStr = "y"
    elif k == 3:
        colorStr = "b"
    elif k == 4:
        colorStr = "g"
    elif k == 5:
        colorStr = "pink"
    poly = Polygon(seg, facecolor=colorStr)  # r, y, b, g, pink
    ax.add_patch(poly)


###############################
# 开始上色
name = ""
colorList = []
c = 0
for seg, mName in zip(m.china, m.china_info):
    ttName = mName['OWNER']
    tName = ttName.replace("\x00", "")
    if tName != name:
           colorList = getColorList(tName)
           for i in range(1, 6):  # 从低到高上色
                  if i not in colorList:  # 不存在就上色
                         c = i
                         break
    pColor(seg, c)
    nameDict[tName] = c
    name = tName
plt.show()