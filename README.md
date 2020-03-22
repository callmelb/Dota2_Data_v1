# Dota2数据获取与分析
 数据源1:https://opendota.com
 数据源2:https://open.varena.com
 
 main.py 传入一个比赛id,获取到比赛的详细信息
 
 处理后导出 1.match_id.json  2.pyEcharts导出的match_id.png      data/5289041688这个文件夹里面有生成的样本！！！
 
 java根据python导出的json文件,得到比赛名字，双方战队，英雄id，从图片库中找到对应图片，加载到模板中，再与之前的png拼接，生成最终图片

 python webdriver自动将图片发布社交网站(未完成)

# 2020-03-20 更新 新增了制作经济曲线图的方法  get_png_v2(match_id)
  新版本曲线图中由v1版本的pyEchart改为了Matplotlib
  
  v2增加了特殊点标识，十分钟经济差异的标注及比赛结束标注，优化了曲线的xy轴的间距，通过识别阵营做出不同颜色标注
 

# 后续待做
 1.如何使用java调用python，并且保证第三方库正常运行???
 
 2.将数据多存一份到阿里云的Mysql服务器上
 
 3.做一个简易网页，绑定到华为云服务器和域名(mrgameboy.com)上
