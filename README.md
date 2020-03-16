# Dota2数据获取与分析
 数据源1:https://opendota.com
 数据源2:https://open.varena.com
 
 main.py 传入一个比赛id,获取到比赛的详细信息，处理后导出 1.match_id.json  2.pyEcharts导出的match_id.png
 
 java根据比赛id处理python得到的json和png，再拼接一个png图片，获得最终图片

 python webdriver自动将图片发布社交网站(未完成)

# 后续待做
 1.如何使用java调用python，并且保证第三方库正常运行???
 2.将数据多存一份到阿里云的Mysql服务器上
 3.做一个简易网页，绑定到华为云服务器和域名(mrgameboy.com)上
