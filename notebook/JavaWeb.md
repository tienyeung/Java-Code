[toc]

# 一 web概念

```
- JavaWeb：使用Java语言开发基于互联网的项目.
- 架构：
	+ C/S: Client/Server 客户端/服务器端
		* 在用户本地有一个客户端程序，在远程有一个服务器端程序.
		* 优点：用户体验好；缺点：开发、安装，部署，维护麻烦.
	+ B/S: Browser/Server 浏览器/服务器端
		* 只需要一个浏览器，用户通过不同的网址(URL)，客户访问不同的服务器端程序.
		* 优点：开发、安装，部署，维护简单；缺点：对硬件要求过高.
- B/S架构详解
	+ 静态资源：
		* 使用静态网页开发技术发布的资源;
		* 特点：所有用户访问得到的结果一致(文本，图片，音频、视频, HTML/CSS/JavaScript)；如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器。浏览器中内置了静态资源的解析引擎，可以展示静态资源。
		* 静态资源：
			* HTML：用于搭建基础网页，展示页面的内容
			* CSS：用于美化页面，布局页面
			* JavaScript：控制页面的元素，让页面有一些动态的效果
	+ 动态资源：
		* 使用动态网页开发技术发布的资源(jsp/servlet,php,asp...);
		* 特点：所有用户访问，得到的结果可能不一样;如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器.
```

# 二 静态网页技术

## 1 HTML

```
语法：
	+ 标签：
		* 围堵标签：有开始标签和结束标签。如 <html> </html>
		* 自闭和标签：开始标签和结束标签在一起。如 <br/>
	+ 属性：在开始标签中可以定义属性(键值对,值需要用引号)
		*color：颜色;width：宽度;size：高度;align:(center:居中;left：左对齐;right：右对齐)
	
	+ 标签学习：
		1 文件标签：构成html最基本的标签
			* <!DOCTYPE html>：html5定义
			* html:html文档的根标签
			* head：头标签。用于指定html文档的一些属性；引入外部的资源
				* title：标题标签
			* body：体标签
		2 文本标签：
			* <!-- 注释内容 -->
			* <h1> to <h6>：标题标签
			* <b>：字体加粗,<i>：字体斜体
			* <font 属性>:字体标签
			* <p>：段落标签
			* <br/>：换行标签
			* <hr/>：水平线
		3 图片标签：<img src="位置" 属性对 />
		4 列表标签：
			* 有序：ol->li
			* 无序：ul->li
		5 链接标签：<a href="" target> </a>
			- target：指定打开资源的方式;
				* _self:默认值，在当前页面打开
				* _blank：在空白页面打开
		6 div和span(结合css)
			* div：每一个div占满一整行，块级标签
			* span：文本信息在一行展示，行内标签、内联标签
		7 语义化标签：提高程序可读性
			* <header>：页眉
			* <footer>：页脚
		8 表格标签：
			- table：定义表格（由行及其内部的单元格组成）
				* <caption>：定义表格标题
				* 语义化标签：
					* <thead>：表示表格的头部分
					* <tbody>：表示表格的体部分
					* <tfoot>：表示表格的脚部分
				* 属性：
					* width：宽度
					* border：边框
					* cellpadding：定义内容和单元格的距离
					* cellspacing：定义单元格之间的距离。如果指定为0，则单元格的线会合为一条
					* bgcolor：背景色
					* align：对齐方式
			- tr：定义行
				* bgcolor：背景色
				* align：对齐方式
			- td：定义单元格
				* colspan：合并列
				* rowspan：合并行
			- th：定义表头单元格
			
			9 表单标签：用于采集用户输入的数据的，用于和服务器进行交互。
				+ form：定义一个采集用户数据的范围()
					* 表单项中的数据要想被提交：必须指定其name属性
					- 属性：
						* action：指定提交数据的URL
						* method：指定提交方式:get/post
							* get：
								 * 请求参数会在地址栏中显示
								 * 请求参数大小是有限制的
								 * 不太安全
							* post：
								 * 请求参数不会再地址栏中显示
								 * 请求参数的大小没有限制
								 * 较为安全
				+ 表单项：
					- input：可以通过type属性值，改变元素展示的样式
						* type：
								* text：文本输入框，默认值
									* placeholder：指定输入框的提示信息
								* password：密码输入框
								* radio：单选框；checkbox：复选框
									* 一般会给每一个单选框提供value属性，指定其被选中后提交的值
									* checked 默认选中状态
								* file：文件选择框
								* hidden：隐藏域，用于提交一些信息
								* 按钮：
									* submit：提交按钮。可以提交表单
									* button：普通按钮
									* image：图片样式提交按钮
					- label：指定输入项的文字描述信息
						* label的for属性一般会和 input 的 id属性值 对应(让input输入框获取焦点)
					- select：下拉列表；子元素：option，指定列表项
					- textarea：文本域
						* cols：指定列数，每一行有多少个字符
						* rows：默认多少行。
		
```

## 2 CSS

```
1.概念：Cascading Style Sheets 层叠样式表(多个样式可以作用在同一个html的元素上，同时生效)
2.css结合html方式
	+ 内联样式：在标签内使用style属性指定css代码
		* 如：<div style="color:red;">hello css</div>
	+ 内部样式：在head标签内，定义style标签
		* <style> div{color:blue;} </style>
	+ 外部样式：外部定义css资源文件，head中定义link标签，引入外部的资源文件
		* <link rel="stylesheet" href="./css/a.css">

3.语法：
	选择器 {
			属性名1:属性值1;
			属性名2:属性值2;
			...
		}
4.选择器：筛选具有相似特征的元素
	+ 基础选择器：
		- id选择器：选择具有相同标签名称的元素
			* 语法：#id{}
		- 元素选择器：选择具有相同标签名称的元素
			* 语法：标签名称{}
			* id选择器优先级高于元素选择器
		- 类选择器
			* .class属性值{}
			* 类选择器选择器优先级高于元素选择器
	+ 扩展选择器：
		- 选择所有元素：*{}
		- 并集选择器：选择器1,选择器2{}
		- 子选择器：筛选选择器1元素下的选择器2元素;选择器1 选择器2{}
		- 父选择器：筛选选择器2的父元素选择器1;选择器1 > 选择器2{}
		- 属性选择器：选择元素名称，属性名=属性值的元素;元素名称[属性名="属性值"]{}
		- 伪类选择器：选择一些元素具有的状态;元素:状态{}
				* 状态：
						* link：初始化的状态v
						* visited：被访问过的状态
						* active：正在访问状态
						* hover：鼠标悬浮状态
5.属性：
	- 字体：
		* font-size：字体大小
		* color：文本颜色
		* text-align：对其方式
		* line-height：行高 
	- 背景
		* background：复合属性
	- 边框
		* border：边框大小，复合属性
	- 尺寸
		* width：宽度
		* height：高度
	- 盒子模型：控制布局
		* margin：外边距 (auto 自适应居中)
		* padding：内边距
			* 默认情况下内边距会影响整个盒子的大小：box-sizing: border-box即可固定盒子的大小
		* float：放在一行展示，分别处于不同的位置
			* left
			* right
			* ...
		
```

## 3 JavaScript

```
1.概念：客户端脚本语言;增强用户和html页面的交互过程，可以来控制html元素，让页面有一些动态的效果;
	- 运行在客户端浏览器中的。每一个浏览器都有JavaScript的解析引擎
	- 脚本语言：不需要编译，直接就可以被浏览器解析执行
	- JavaScript = ECMAScript + JavaScript自己特有的东西(BOM+DOM)
	
2.JavaScrip与html结合方式：
	+ 内部JS：定义<script>，标签体内容就是js代码
	+ 外部JS：定义<script>，通过src属性引入外部的js文件
		* 标签可在任意地方，但其位置与执行顺序有关
3.语法：
	+ 注释
		*  单行注释：//注释内容 ； 多行注释：/*注释内容*/
	+ 数据类型:
		- 原始数据类型：
			* number：数字;整数/小数/NaN(not a number)
			* string：字符串
			* boolean: true和false
			* null：一个对象为空的占位符
			* undefined：未定义(变量没有给初始化值，则会被默认赋值为undefined)
		- 引用数据类型：对象(BOM,DOM)
	+ 变量:
		- JavaScript是弱类型语言(在开辟变量存储空间时，不定义空间将来的存储数据类型，可以存放任意类型的数据)
		- 语法：var 变量名 = 初始化值;
		- typeof()：获取变量的类型。
	+ 运算符
		* 如果运算数不是运算符所要求的类型，那么js引擎会自动的将运算数进行类型转换
			* string转number：按照字面值转换。如果字面值不是数字，则转为NaN（不是数字的数字）
			* boolean转number：true转为1，false转为0
		* 全等于 === ：在比较之前，先判断类型，如果类型不一样，则直接返回false
		* 三元 表达式? 值1:值2;
	+ 流程控制
		- 与java相同
	+ 特殊语法
		* 语句以;结尾，如果一行只有一条语句则 ;可以省略 (不建议)
		* 变量的定义使用var关键字，也可以不使用，但定义的变量是全局变量(不建议)
4.基本对象
	+ Function：函数(方法)对象
		- 创建
			* function 方法名称(形式参数列表){
                        方法体
                    }
    	* var 方法名 = function(形式参数列表){
                        方法体
                   } 
    - 属性：函数对象.length:参数个数
    - 特点：
    		* 形参的类型不用写,返回值类型也不写
    		* 方法是一个对象，如果定义名称相同的方法，会覆盖
    		* 方法的调用只与方法的名称有关，和参数列表无关(调用方法时实际输入的参数个数可以和形参个数不同)
    		* 在方法声明中有一个隐藏的内置对象（数组）arguments,封装所有的实际参数
   + Array:数组对象
   	 - 创建：
    	* var arr = new Array(默认长度/元素列表)
    	* var arr = [元素列表]；
     - 方法：
     	* join(分隔符):将数组中的元素按照指定的分隔符拼接为字符串
     	* push()	向数组的末尾添加一个或更多元素，并返回新的长度。
     - 属性：数组对象.length:元素个数
     - 特点：
     	* 数组元素的类型可变的
     	* 数组长度可变的
    + Date：日期对象
    	- 创建：var date = new Date();
    	- 方法：
    		* toLocaleString()：返回当前date对象对应的时间本地字符串格式
    		* getTime():获取毫秒值。返回当前日期对象描述的时间到1970年1月1日零点的毫秒值差
    + Math：数学对象
    	- 创建： Math.方法名()
    	- 方法：
    		* random():返回(0,1]之间的随机数
    		* round(x)：把数四舍五入为最接近的整数。
    	- 属性：PI
    + RegExp：正则表达式对象
    	- 创建：var reg = /正则表达式/；var reg = new RegExp("正则表达式");
    	- 方法：test(参数):验证指定的字符串是否符合正则定义的规范	
    		* regex.test(str)
    + Global
    	- 创建：全局对象，不需要对象就可以直接调用：方法名();
    	- 方法：
    		* encodeURI(str):url编码/decodeURI(str):url解码
    		* parseInt(str):将字符串转为数字：逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number
    		* eval(str):将JavaScript字符串作为脚本代码来执行
```

```
5.BOM
	+ 概念：Browser Object Model 浏览器对象模型
		- 将浏览器的各个组成部分封装成对象：
			* Window：窗口对象
      * //Navigator：浏览器对象
      * //Screen：显示器屏幕对象
      * History：历史记录对象
      * Location：地址栏对象
      
	+ Window：窗口对象
		- 创建：无需创建 window.方法名();
		- 方法
			1 弹出框有关：
				* alert()	显示带有一段消息和一个确认按钮的警告框。
				* confirm()	显示带有一段消息以及确认按钮和取消按钮的对话框。(确定:true;取消:false)
				* prompt() 显示可提示用户输入的对话框;返回值：获取用户输入的值。
			2 开闭有关：
				* close() 关闭浏览器窗口 ;对象.close() 关闭对象窗口
				* open() 打开一个新的浏览器窗口,返回新window对象
			3 定时器相关：
				* setTimeout(js片段/方法对象，毫秒值) 在指定的毫秒数后调用函数或计算表达式。
				* clearTimeout(定时器id) 取消由 setTimeout() 方法设置的 timeout。
				* setInterval(js片段/方法对象，毫秒值)	按照指定的周期（以毫秒计）来调用函数或计算表达式。
				* clearInterval(定时器id)	取消由 setInterval() 设置的 timeout
		- 属性：
			* 获取其他BOM对象：
            history
            location
            Navigator
            Screen:
       * 获取DOM对象
            document
		- 特点
			* Window对象无需创建:window.方法名()或方法名()
			
	+ Location：地址栏对象
		- 创建：window.location/location
		- 方法：reload()	重新加载当前文档。
		- 属性：href	设置或返回完整的URL。
	+ History：历史记录对象
	
	
6.DOM
	- 概念：Document Object Model 文档对象模型
	- 功能：控制html文档的内容；将标记语言文档的各个组成部分，封装为对象。可以使用这些对象，对标记语言文档进行CRUD的动态操作
	
	+ 核心 DOM：
		- Document：文档对象
			* 创建：document/window.document
			* 方法：
				 1 获取Element对象：
						* getElementById("id值"):通过元素的id获取元素对象(Element)
            * getElementsByTagName()：根据元素名称获取元素对象们。返回值是一个数组
            * getElementsByClassName():根据Class属性值获取元素对象们。返回值是一个数组
						*	getElementsByName(): 根据name属性值获取元素对象们。返回值是一个数组
					2 创建其他DOM对象：createComment()...
		- Element：元素对象
			* 创建：通过document来获取和创建
			* 方法：
				* removeAttribute()：删除属性
				* setAttribute(属性，值)：设置属性
				* 修改属性值：元素对象.属性=修改后内容
		- Attribute：属性对象
		- Text：文本对象
		- Comment:注释对象
		- Node：节点对象，其他5个的父对象
			* 特点：所有dom对象都可以被认为是一个节点
			* 方法：CRUD dom树
				* appendChild()：向节点的子节点列表的结尾添加新的子节点。
				* removeChild()	：删除（并返回）当前节点的指定子节点。
				* replaceChild()：用新节点替换一个子节点。
			* 属性：parentNode 返回节点的父节点。
			
	- XML DOM
	- HTML DOM
		* 标签体的设置和获取：元素对象.innerHTML=修改后内容
		* 控制元素样式：使用元素的style属性来设置；通过元素的className属性来设置其class属性值；
			* div1.style.fontSize = "20px";
			* div1.className=.div1
			
			
7.事件监听机制
	- 概念：某些组件被执行了某些操作后，就触发某些代码的执行
	- 注册监听：将事件，事件源，监听器(代码)结合在一起。当事件源上发生了某个事件，则触发执行某个监听器代码。
		* 在html标签上，指定事件的属性(操作)，操作=js代码
		*√ js代码块中指定元素对象的操作属性：元素.onclick=函数名...
	- 常见事件：
			1 点击：
				* onclick 单击
				* ondblclick 双击
			2 焦点：
				* onblur：失去焦点
				* onfocus:元素获得焦点
			3 加载：
				* onload：一张页面或一幅图像完成加载。
			4 鼠标：
				* onmousedown	鼠标按钮被按下。
					* 定义方法时定义一个形参接受event对象，其button属性可获取鼠标
				* onmouseup	鼠标按键被松开。
				* onmousemove	鼠标被移动。
				* onmouseover	鼠标移到某元素之上。
				* onmouseout	鼠标从某元素移开。
			5 键盘：
				* onkeydown	某个键盘按键被按下。	
				* onkeyup		某个键盘按键被松开。
				* onkeypress	某个键盘按键被按下并松开。
			6 选择和改变
				* onchange	域的内容被改变。
				* onselect	文本被选中。
			7 表单
				* onsubmit 确认按钮被点击。
				* onreset	重置按钮被点击。
```

## 4 BootStrap

```
1.概念：前端开发的框架，基于HTML,CSS,JavaScript,使web开发更加快捷
	- 定义了很多的css样式和js插件
	- 响应式布局：同一套页面可以兼容不同分辨率的设备
2.准备：下载Bootstrap，导入其中的css/fonts/js文件
3.响应式布局：
	- 实现：依赖于栅格系统：将一行平均分成12个格子，可以指定元素占几个格子
	- 步骤：
    1. 定义容器。相当于之前的table：<div class="container">
      * 容器分类：
        1. container：两边留白
        2. container-fluid：每一种设备都是100%宽度
    2. 定义行。相当于之前的tr   样式：row
    3. 定义元素。指定该元素在不同的设备上，所占的格子数目。样式：col-设备代号-格子数目 <div class="col-md-4">
		* 设备代号：
			1. xs：超小屏幕 手机 (<768px)：col-xs-12
			2. sm：小屏幕 平板 (≥768px)
			3. md：中等屏幕 桌面显示器 (≥992px)
			4. lg：大屏幕 大桌面显示器 (≥1200px)

	* 注意：
		1. 一行中如果格子数目超过12，则超出部分自动换行。
		2. 栅格类属性可以向上兼容。栅格类适用于与屏幕宽度大于或等于分界点大小的设备。
		3. 如果真实设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素沾满一整行。
		
4.css样式
	+ 全局CSS样式
    - 按钮 class="btn btn-default"
    - 图片 class="img-circle"
    - 表格 class="table table-hover"
    - 表单 class="form-horizontal" 
   + 组件：导航条、分页条
   + 插件：轮播图

```

## 5 XML

```
1.概念：Extensible Markup Language 可扩展标记语言
		* 可扩展：标签都是自定义的。 <user>  <student>
	功能：存储数据(配置文件/在网络中传输)
	与html区别：
		* xml标签都是自定义的，html标签是预定义。
		* xml的语法严格，html语法松散
		* xml是存储数据的，html是展示数据
2.语法：
		* xml文档的后缀名 .xml
		* xml第一行必须定义为文档声明:<?xml version='1.0' ?>
		* xml文档中有且仅有一个根标签
		* 属性值必须使用引号(单双都可)引起来
		* 标签必须正确关闭
		* xml标签名称区分大小写
3.组成部分：
	- 文档声明：<?xml 属性列表 ?>
		* 属性列表：	
				* version：版本号，必须的属性
				* encoding：编码方式：ISO-8859-1(默认)
				* standalone：是否独立
				* 指令：结合css： <?xml-stylesheet type="text/css" href="a.css" ?>
	- 标签：自定义
	- 属性：id属性值唯一
	- 文本：
		* CDATA区：在该区域中的数据会被原样展示 <![CDATA[ 数据 ]]>
		
4.约束：规定xml文档的书写规则
	- DTD:一种简单的约束技术（无法限定内容）
		- 引入dtd文档到xml：
			* 内部dtd：将约束规则定义在xml文档中
			* 外部dtd：将约束的规则定义在外部的dtd文件中
					* 本地：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
					* 网络：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">
	- Scheme：一种复杂的约束技术
		- 引入：
			<根标签  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"（xsi前缀）
				xmlns="http://www.itcast.cn/xml"（每一个xsd约束声明一个前缀）
				xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"（xsd文件命名空间）>
5.解析：操作xml文档，将文档中的数据读取到内存中
	- 方式：
		* DOM：将标记语言文档一次性加载进内存，在内存中形成一颗dom树（可CRUD，占内存）
		* SAX：逐行读取，基于事件驱动的。(只读，不占内存)
	- 解析器：JAXP（支持dom和sax）、DOM4J、PULL（Android，sax）、Jsoup
		* ​Jsoup：Java 的HTML解析器，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
	- 步骤：
		* 导入jar包
		* 获取Document对象:通过类加载器找到xml文件，再用Jsoup.parse获取D对象
		* 获取Element对象
		* 获取数据
	- ​对象的使用
		1 Jsoup:工具类，可以解析html或xml文档，返回Document
			- parse(File in, String charsetName)
			- parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象。			
		2 Document：文档对象。代表内存中的dom树，返回Elements
			* getElementById(String id)：根据id属性值获取唯一的element对象
			* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
			* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
			* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
		3 Elements：元素Element对象的集合。 ArrayList<Element>
		4 Element：
			* 获取元素对象方法getXxxbyXxXx()
			* 获取属性值：String attr(String key)
			* 获取文本内容：String text()、String html()
		5 Node：Document和Element的父类
	
	- 快捷查询方式：
		1.Selector选择器：Elements select(String cssQuery)
			* Element ele = document.select("name")
		2.XPath：XPath即为XML路径语言，用来确定XML文档中某部分位置
			- 根据document对象，创建JXDocument对象
				JXDocument jxDocument = new JXDocument(document);
			- 返回JXNode类列表：
				* List<JXNode> jxNodes = jxDocument.selN("//student");
		
		
			
```

# 三 动态网页技术

## 1 Tomcat

```
1.服务器：安装了服务器软件的计算机
	* 服务器软件对用户的请求进行接收，处理和响应
	* Java相关web服务器软件：webLogic,webSphere,JBoss,Tomcat(Apache)
2.Tomcat
	-1 部署方式：
		- 直接：直接将项目(可打包成war包)放置在webapps目录下即可
			* 访问：ip/项目名
		- 配置文件：conf/server.xml
			* <Host>标签体：<Context docBase=".." path="/.." />
		- ​xml文件：conf/Catalina/localhost创建任意名称的xml文件
			* 文件中编写<Context docBase=".." />
  -2 静态项目和动态项目：
   	- 动态项目结构：
    	-- 项目的根目录
						-- WEB-INF目录：
							-- web.xml：web项目的核心配置文件
							-- classes目录：放置字节码文件的目录
							-- lib目录：放置依赖的jar包
```

## 2 Servlet

```
1.概念：运行在服务器端的小程序
	* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
	* 将来我们自定义一个类，实现Servlet接口，复写方法。
2.实现：
	* 定义类实现Servlet接口及其方法
	* 配置Servlet（在web.xml中）：定义<servlet>和<servlet-mapping>
3.原理：
	-1 服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
	-2 查找web.xml文件，是否有对应的<url-pattern>标签体内容
	-3 如果有，则在找到对应的<servlet-class>全类名
	-4 tomcat会将字节码文件加载进内存(Class.forName())，并且创建其对象(cls.newInstance())
	-5 调用其方法
4.Servlet生命周期方法：
	-1：init()：创建时执行，只执行一次（单例）
		* 可配置Servlet创建时机(默认第一次访问是创建)：
			<servlet> -> 设置<load-on-startup>值：负：默认 0或正：服务器启动时创建
	-2：service()：每次Servlet访问时执行
	-3：destory()：服务器正常关闭时执行一次
5.Servlet3.0：支持注解配置。可以不需要web.xml了
	* 类上使用@WebServlet注解，进行配置:@WebServlet("资源路径")
6.Servlet的继承关系：
	Servlet - GenericServlet - HttpServlet
	* GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象(将来定义Servlet类时，可以继承GenericServlet，实现service()方法即可)
	* ​HttpServlet抽象类：对http协议的一种封装(定义类继承HttpServlet,复写doGet/doPost方法)
```

## 3 HTTP

```
1.概念：Hyper Text Transfer Protocol 超文本传输协议
	* 定义了客户端和服务器端通信时，发送数据的格式
	* 特点：基于TCP/IP的高级协议、默认端口号:80、基于请求/响应模型(一次请求对应一次响应)、无状态(每次请求之间相互独立，不能交互数据)
	
2.请求和响应
	- 请求消息数据格式
		-1 请求行：请求方式 请求url 请求协议/版本
			* GET /login.html	HTTP/1.1
			- HTTP中请求方式有7种：
				* GET:
					1. 请求参数在请求行中，在url后。
					2. 请求的url长度有限制的
					3. 不太安全
				* POST
					1. 请求参数在请求体中
					2. 请求的url长度没有限制的
					3. 相对安全
		-2 请求头：请求头名称: 请求头值
			* User-Agent:浏览器告诉服务器访问时使用的浏览器版本信息
			* Referer：http://localhost/login.html （用于防盗链和统计工作）
		-3 请求空行：空行，就是用于分割POST请求的请求头和请求体的。
		-4 请求体（正文）：封装POST请求消息的请求参数的
		
	- 响应消息数据格式：
		-1. 响应行：协议/版本 响应状态码 状态码描述
			* 响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
				1xx：服务器接收客户端消息，但没有接收完成，等待一段时间后，发送1xx多状态码
				2xx：成功。代表：200
				3xx：重定向。代表：302(重定向)，304(访问缓存)
				4xx：客户端错误。
							* 404（请求路径没有对应的资源） 
							* 405：请求方式没有对应的doXxx方法
				5xx：服务器端错误。代表：500(服务器内部出现异常)			
		-2. 响应头：头名称： 值
			* Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
			* Content-disposition：服务器告诉客户端以什么格式打开响应体数据
			* in-line:默认值,在当前页面内打开
			* attachment;filename=xxx：以附件形式打开响应体。文件下载
		-3. 响应空行
		-4. 响应体:传输的数据

3.Request：request对象用于获取请求消息
		-1 获取请求行数据：GET /example/demo?name=zhangsan HTTP/1.1
			* 获取请求方式：String getMethod()  ：GET
			*​ 获取虚拟目录：String getContextPath()：/example
			* 获取Servlet路径：String getServletPath()：/demo
			* 获取get方式请求参数：String getQueryString()：name=zhangsan
			*​ 获取请求URI：
				* String getRequestURI()：/example/demo
				* StringBuffer getRequestURL()：http://localhost/day14/demo1/example/demo
			* 获取协议及版本：String getProtocol()：HTTP/1.1
			* 获取客户机的IP地址：String getRemoteAddr()
		-2 获取请求头数据
			* ​String getHeader(String name):通过请求头的名称获取请求头的值
			* Enumeration<String> getHeaderNames():获取所有的请求头名称
		-3 获取请求体数据：只有POST请求方式才有请求体
			-  获取流对象
				*  BufferedReader getReader()：获取字符输入流，只能操作字符数据
				*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据

		-4​获取请求参数通用方式(无论get还是post)
			* String getParameter(String name):根据参数名称获取参数值
      * String[] getParameterValues(String name):根据参数名称获取参数值的数组
      * Enumeration<String> getParameterNames():获取所有请求的参数名称
      * Map<String,String[]> getParameterMap():获取所有参数的map集合
    -5 乱码问题：
     	* get：tomcat 8 已经将get方式乱码问题解决
     	* post：在获取参数前，设置request的编码
     		* request.setCharacterEncoding("utf-8");
    -6 请求转发：一种在服务器内部的资源跳转方式
    	1.通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
    	2.使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response) 
    		* 浏览器地址栏路径不发生变化、只能转发到当前服务器内部资源中、转发是一次请求
    -7 共享数据
    	* 域对象：一个有作用范围的对象，可以在范围内共享数据
    	* request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
    	* 方法：
				1. void setAttribute(String name,Object obj):存储数据
				2. Object getAttitude(String name):通过键获取值
				3. void removeAttribute(String name):通过键移除键值对
    -8 获取ServletContext
    	* ServletContext getServletContext()
    - 案例：用户登录
    	* 功能：验证登录是否成功
    	* 实现文件：domain-User类，dao-UserDao，Utils-JDBCUtils，servlet-(Login,success,fail)
    	* 实现：
    		* domain-User类：简单JavaBean类
    		* Utils-JDBCUtils：Druid数据连接池的建立，返回DataSource对象
    		* dao-UserDao：获取连接池对象，建立连接进行查询，返回User对象
    		* servlet-Login：获取表单提取的数据并封装成User类，经由dao验证此类是否在数据库中存在，存在转发servlet-success，否则转发servlet-fail。
    		* BeanUtils(Apache):简化数据封装(封装JavaBean) populate(Javabean,Map)
    			* JavaBean:标准的Java类
    				要求： 1. 类必须被public修饰
									2. 必须提供空参的构造器
									3. 成员变量必须使用private修饰
									4. 提供公共setter和getter方法	

4.Response：设置响应消息数据
	-1 设置响应行
		* 设置状态码：setStatus(int sc)
	-2 设置响应头
		* setHeader(String name, String value) 
		* 重定向：response.sendRedirect("/path");
			* 重定向的特点:redirect
				1.地址栏发生变化(转发地址栏不发生变化)
				2.重定向可以访问其他站点(服务器)的资源(转发只能访问本地服务器资源)
				3.重定向是两次请求。不能使用request对象来共享数据(转发是一次请求，可以使用request对象来共享数据)
	-3 设置响应体
		* 获取输出流：
			* 字符输出流：PrintWriter getWriter()：write("str")
				* 设置中文编码：response.setContentType("text/html;charset=utf-8");
			* 字节输出流：ServletOutputStream getOutputStream()：write(str.getBytes())
		* 使用输出流：将数据输出到客户端浏览器
		
	-4 ServletContext对象：代表整个web应用，可以和程序的容器(服务器)来通信
		- 获取：
			1. 通过request对象获取：request.getServletContext();
			2. 通过HttpServlet获取：this.getServletContext();
		- 功能：
			* 获取MIME类型：
				* MIME类型:在互联网通信过程中定义的一种文件数据类型
				* 格式： 大类型/小类型   text/html		image/jpeg
				* 获取：String getMimeType(String file)  
	 		* 域对象：共享数据
				* setAttribute(String name,Object value)
				* getAttribute(String name)
				* removeAttribute(String name)
				* ServletContext对象范围：所有用户所有请求的数据
		- 获取文件的真实(服务器)路径：
			* String getRealPath(String path)  
```

## 4 会话技术

```
1.会话：一次会话中包含多次请求和响应。
	* 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
	* 功能：在一次会话的范围内的多次请求间，共享数据
	* 方式：客户端会话技术：Cookie/服务器端会话技术：Session

2.cookie：客户端会话技术，将数据保存到客户端
	-1 实现：基于响应头set-cookie和请求头cookie实现
		1. 创建Cookie对象，绑定数据
			* new Cookie(String name, String value) 
		2. 发送Cookie对象
			* response.addCookie(Cookie cookie) 
		3. 获取Cookie，拿到数据
			* Cookie[]  request.getCookies() 
  -2 细节：
  	1 一次可以发送多个cookie：创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可
  	2 默认情况下，当浏览器关闭后，Cookie数据被销毁；
			* 持久化存储：setMaxAge(int seconds)
				* 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
				* 负数：默认值
				* 零：删除cookie信息
		3 在tomcat 8 之前 cookie中不能直接存储中文数据，需要将中文数据转码---一般采用URL编码(%E3)
		4 cookie共享：在一个tomcat服务器,各web项目默认情况下cookie不能共享
			* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录；如果要共享，则可以将path设置为"/"
			* 不同的tomcat服务器间:如果设置一级域名相同，那么多个服务器之间cookie可以共享
		-3 特点：
			* cookie存储数据在客户端浏览器
			* 浏览器对于单个cookie的大小有限制(4kb) 以及对同一个域名下的总cookie数量也有限制(20个)
		-4 作用：
			* cookie一般用于存出少量的不太敏感的数据
			* 在不登录的情况下，完成服务器对客户端的身份识别			
```

```
3.Session：服务器端会话技术，将数据保存在服务器端的对象中
	-1 实现:Session的实现依赖于Cookie
		* 获取HttpSession对象：HttpSession session = request.getSession();
		* 使用HttpSession对象：
			Object getAttribute(String name)  
			void setAttribute(String name, Object value)
			void removeAttribute(String name)  
	-2 细节：
		* 当客户端关闭后，服务器不关闭，两次获取session不是同一个；如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
		* 客户端不关闭，服务器关闭后，两次获取的session不是同一个；
			* session的钝化：在服务器正常关闭之前，将session对象系列化到硬盘上
			* session的活化：在服务器启动后，将session文件转化为内存中的session对象即可。
		* session销毁：
			* 服务器关闭
			* session对象调用invalidate()
			* session默认失效时间 30分钟
				<session-config>
		        <session-timeout>30</session-timeout>
		    </session-config>
	-3 特点：
		* session用于存储一次会话的多次请求的数据，存在服务器端
		* session可以存储任意类型，任意大小的数据
	-4 session与Cookie的区别
		* session存储数据在服务器端，Cookie在客户端
		* session没有数据大小限制，Cookie有
		* session数据安全，Cookie相对于不安全

```

## 5 JSP

```
1.概念：Java Server Pages：java服务器端页面
	* 一个特殊的页面，其中既可以指定定义html标签，又可以定义java代码
	* 用于简化书写
	* JSP本质上就是一个Servlet
2.JSP的脚本
	* <%  代码 %>：service()方法实现
	* <%! 代码 %>：定义成员变量或方法
	* <%= 代码 %>：输出语句到页面上
3.JSP的内置对象(不需要获取和创建，可以直接使用的对象)
	* jsp一共有9个内置对象
		* request/response
		* out：字符输出流对象。可以将数据输出到页面上(≈response.getWriter())
			* 二者区别：response.getWriter()数据输出永远在out.write()之前；在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
```



