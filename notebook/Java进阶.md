[toc]

# 1 多线程编程

## 基础

1. **Thread类**：

   一个类只要继承了此类，就成了线程的主体类,覆写主方法$run()$实现多线程处理，要执行的功能都在此方法中定义。但run()方法无法直接调用，必须启用$start()$完成,线程执行顺序是不可控的。必须使用start()方法的原因在于其通过JVM以JNI技术实现对于不同操作系统的底层函数的调用，从而可在不用操作系统上实现资源的调用。

2. **Runnable接口**：

   ` public Thread(Runnable target)`

   在Thread类的其中一个构造方法内可接受Runnable对象，从而实现start()启动多线程；其优势在于不再局限于单继承，这样的设计才是标准型的设计；

   ```java
   new Thread(()->{
                   for(int y = 0;y<10;y++){
                       System.out.println(title+" 运行： "+y);
                   }
               }).start();
   ```

    Thread自动选择构造函数来接受Runnable对象，Lambda函数编程的参数为空，后面代码块为对Runnable接口（函数式接口）方法的覆写；

3. 二者关系：

   - Runnable可避免单继承的局限；
   - Thread类其实是Runnable接口的子类，其继承父类的run()方法；
   - Thread类：+start()方法；
   - Runnable描述的是多个线程操作的资源，而Thread描述的是每一个线程对象；

4. **Callable接口**：

   Runnable缺点：但线程执行完毕后无法获取返回值。

   `java.util.concurrent.Callable`

   ```java
   @FunctionalInterface
   public interface Callable<V>(){
     public V call() throws Exception;
   }
   ```

## 操作方法

1. 线程的命名：

   - 构造方法：`public Thread(Runnable target,String name)`
   - 设置名字：`public final void setName(String name)`
   - 取得名字：`public final String getName()`
   - 获取当前线程：`Thread.currentThread()`

   主线程负责处理整体流程，子线程负责处理耗时操作；main就是一个主线程。

2. 线程的休眠：

   `public static void sleep(long millis[,int, nanos]) throws InterruptedException`

   休眠时可能出现中断异常；

3. 线程的中断：

   线程的打断来自于其他线程的打断完成的；

   `public boolean isInterrupt()`

   `public void interrupt()`
   
4. 线程的强制执行

   `public static void join() throws InterruptedException` `

   在进行线程强制执行的时候一定要获取强制执行的线程对象之后才可以启用join进行强制执行；

5. 线程礼让：

   现将资源让出去让别的线程先执行：`Thread.yield()`,每次调用只会礼让一次当前的资源。

6. 线程优先级：

   - 设置优先级：`Thread.setPriority(int newPriority)`
   - 获取优先级：`Thread.getPriority()`

   - 优先级：
     - MAX_PRIORITY(10),NORM_PRIORITY(5),MIN_PRIORITY(1)

   主线程和默认线程都是中等优先级；
   
7. 线程的优雅停止：

   已废除线程的停止(stop)，销毁(destory)，挂起(suspend)指令,因为可能导致死锁；

   ```java
   public static boolean flag = true;
   {
     //code
   }
   Thread.sleep(100)//running 100 ms
   flag = false;
   ```

8. 线程的守护：

   设置：`public final void setDaemon(boolean on) `

   判断：`public final boolean isDaemon()`

   守护线程围绕在用户线程周围，如果程序执行完毕，守护线程也就消失了，在JVM中最大的守护线程就是GC线程。

## 同步与死锁

1. 同步的引出：当多个线程访问同一资源时，若发生网络延迟（sleep），则多个线程可能都通过了数据判断检测，而同时访问一个资源，此时可能造成越界，使之不符合先前的数据判断检测。

2. **同步**：解决同步的关键是锁，当一个线程执行操作的时候，其他线程外面等待；关键字synchronized实现锁的功能，用其实现同步代码块，此时其中只允许一个线程执行；

   ```java
   synchronized(同步对象){
     同步代码块；
   }
   ```

   但同步处理之后会造成程序整体性能的降低；可以用**同步方法**解决。

3. 死锁：

   若干个线程彼此互相等待，等待对方让出资源；
   
4. **生产者消费者问题**：

   如果要确保生产消费准确无误，即保证不出现以下两个问题：

   	- 生产同时被消费。（容易造成消费结果为null）
   	- 重复生产重复消费。（容易造成消费结果错位）

   那么解决问题的方法就是：

   - 保证生产消费操作的原子性，在其代表的方法前加synchronized；
   - 增加一个变量flag来体现其状态（flag为true时表示只生产不消费）。
     - 对于生产者而言，加入一个判断，若处于仅消费状态，则线程等待（wait），否则开始生产，生产完毕后置flag为仅消费状态，最后唤醒线程（有wait就有notify，且这种方法继承于Object类，一般是super.wait()）；
     - 对于消费者而言，加入一个判断，若处于仅生产状态，则线程等待，否则开始消费，消费完毕后置flag为仅生产状态，最后唤醒线程；

5. 关键字**volatile**：在属性定义上使用，表示此属性为直接属性操作，而不进行副本的拷贝处理，如果使用了**volatile**则表示不使用副本，直接在原始内存上处理，它**并不描述同步**。

# 2 常用类库

## 基础库

1. String类是字符串的首选类型，但其生成的字符串**无法修改**，如果要修改可以用**StringBuffer**类，它没有两种对象实例化方式。

   `public StringBuffer append（String args[]）`相当于“+”操作，“+”在编译后都变成了append方法;

   `public StringBuffer insert(int offset，数据类型 b)`：表示插入数据；

   `public StringBuffer delete(int offset,int index)`:删除数据；

   `public StringBuffer reverse()`:反转！只有StringBuffer类有。

   $StringBuild$类(JDK1.5)与之功能相同，但非线程安全（无synchronized）

2. charSequence接口：

   描述字符串结构的接口，有三种常有子类：String，StringBuffer，StringBuilder；其实其描述的就是字符串。

3. AutoCloseable接口：

   由于资源有限，所以使用后一定要关闭资源；在子类中必须覆写close方法

   `public void close() throws Exception`，但此方法必须结合try...catch语句才能实现自动地关闭。

   ```java
   try(AutoCloseable子类对象){
     子类方法；
   }catch（Exception e）{
     
   }
   ```

4. Runtime类：

   描述运行时状态；每个JVM进程只有一个Runtime对象（单例设计）。

   - 获取实例化对象：`public static Runtime getRuntime()`
   - 获取内核数：`public int availableProcessors()`
   - 获取最大可用内存空间：`public long maxMemory()`
   - 获取可用内存空间：`public long totalMemory()`
   - 获取空闲内存空间：`public long freeMemory()`
   - 手工进行GC处理：`public void gc()`

5. System类：

   - 获取当前日期时间数值：`public static long currentTimeMillis()`可用来计算耗时统计。
   - 进行垃圾回收：`public static void gc()`相当于`Runtime.getRuntime.gc()`

6. Cleaner类：

   提供的是一个对象清理的操作，其主要功能为finialize()方法。Java本身提供给用户收尾的操作，即给每一个实例对象“喘息“的机会。finialize方法（已不建议使用）用于对象的回收释放。JDK1.9后一般使用AutoCloseable或Cleaner。

7. 对象克隆：

   就是对象的复制，及使用已有对象创建新的对象，需要用到Object类中的clone()方法。

   `protected Object clone() throws CloneNotSupportedException`

   所有的类都有clone方法，但不是所有类都希望被克隆。如果要实现克隆，必须实现Cloneable接口，其没有任何方法提供只是描述一种能力。子类中必须覆写clone方法(return super.clone())。须注意的是clone返回的是Object类，当用到克隆时须向下转型。

## 数学类

1. Math.methods()
2. Random类：
   - 产生不大于边界的随机正整数：`public int nextInt(int bound)` 
3. 大数字操作：
   - `public BigInteger(String val)`
   - `public BigDecimal(String val)`
4. 日期类：

- Date类
  - 将long转为Date：`public Date(long date)`
  - 将Date转为long：`public long getTime()`保存的是毫秒的数据级；
- SimpleDateFormat类：是DateFormat的子类
  - 构造函数:`public SimpleDateFormat(String pattern)`
    - 年（yyyy）、月（MM）、日（dd）、时（HH）、分（mm）、秒（ss）、毫秒（SSS）;
  - 日期格式化：`public final String format(Date date)`
  - 字符串转为日期：`public Date parse(String source) throws ParseException`
  - 直接创建一个格式化后的日期：`new SimpleDateFormat("yyyy-MM-dd").format(new Date())`

## 正则表达式

### pattern

1. [数量：单个] 字符集匹配(可以从里面任选一个)
   - [abc]：表示从a、b、c中任选一个；
   - [^abc]：表示不是a、b、c中任意一个；
   - [a-zA-z]：表示任意字母组成不区分大小写；
   - [0-9]：表示由由一位数字组成；
2. [数量：单个] 简化字符集
   - .：表示任意一个字符；
   - \d:等价于[0-9]；\D：等价于[\^0-9]；
   - \s：匹配人一个空格，换行\n，制表符\t；
   - \w：等价于[a-zA-Z_0-9]字母、数字、下划线；
3. 边界匹配：
   - ^：匹配开始；
   - $：匹配结束；
4. 数量表示：
   - ？：出现0次或1次；
   - *：出现0，1，多次；
   - +：出现1或多次；
   - 表达式{n}：表达式长度为n次；
   - 表达式{n，}：表达式长度为n次以上；
   - 表达式{n，m}：表达式长度为n-m次；
5. 逻辑表达式：连接多个正则
   - 表达式X表达式Y：X表达式后接着是Y表达式;
   - 表达式X|表达式Y：二者满足其一；
   - （表达式X）：为表达式设计整体描述

###String对正则的支持

- 字符串是否匹配：`str.matches(regex)`
- 字符串的替换：`str.replaceAll(regex,"")`
- 字符串的拆分：` str.split(regex)`

正则无法对内容进行判断，只能对格式进行判断处理；

1. 电话号码：

   - 1234567 （可7或8位）
   - 0101234567（前面加区号3或4位）
   - (010)-1234567

   `((\\d{3,4})|\\(d{3,4}\\-))\\d{7,8}`

2. email:

   - 用户名可以由字母、数字、_组成（下划线不能在开头）；
   - 域名可以是字母、数字、_、- ，所组成；
   - 后缀：.cn、.com、.net、.com.cn、.gov；

   `[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|net|com.cn|gov)`
   
3. ip:`([12]?[0-9]?[0-9]\\.){3}12]?[0-9]?[0-9]`

###regex包

java.util.regex 两个类：

1. Pattern类： 

   ```java
   Pattern pat = Pattern.compile(regex);
   String result[] = pat.split(str);
   ```

2. Matcher类：

   ```java
   Pattern pat = Pattern.compile(regex);
   Matcher mat = pat.matcher(str);
   mat.matches()//boolean
   ```

一般来说String类够用了，但有些功能比如分组的功能只能Matcher类才能使用；

## 国际化

1. 定义保存文字的区域信息
2. 根据不同的区域语言的编码读取指定的资源信息

- **1 Locale**：描述区域和语言类；
  - 构造：
    - `public Locale(String language)`
    - `pubilc Locale(String language,String Country)`
  - 方法：
    - `public static Locale getDefault()`:获取默认环境；
    - `locale.CHINA`:用常量描述区域信息；

- **2 ResourceBundle**:抽象类；对资源文件进行读取
  - 实例化：`public static final ResourceBundle getBundle(String baseName[,Locale loc])`；
  - 根据key读取资源内容：`public final String getString(String key)`

- **MessageForma**t类:格式化文本处理
  - `public static String format(String pattern,Object...args[])`Object...args[]对应资源文件中的{0}、{1}...

## 开发支持类库

1. UUID
   - `public static UUID randomUUID()`:获取UUID对象，根据时间戳生成随机无重复字符串；
   - `public static UUID fromString(String name)`:从字符串获取UUID内容；

2. optional类：进行null相关的处理
3. ThreadLocal类：解决线程数据同步问题;每个线程有独立的数据空间；只允许保存一个数据；
   - 构造:`public ThreadLocal()`
   - 设置数据：`public void set(T value)`
   - 取出数据：`public T get()`
   - 删除数据：`public void remove()`
4. 定时调度：
   - TimerTask类（abstract类，继承于Runnable）：实现定时任务处理(任务主体)
   - Timer类：实现定时任务的启动
     - 启动：`public void schedule(TimerTask task,long delay)`
5. Base64编码与解码:
   - 加密：`new String(Base64.getEncoder().encode(str.getBytes()))`
   - 解密：`new String(Base64.getDecoder().decode(str.getBytes()))`
   - Base64处理的都是byte数组，返回的也是byte[]；

## 比较器

进行大小关系的确定判断;默认的类默认情况下无法实现数组排序和比较需求的。

为了统一比较规则，所以有比较器的接口：Comparable接口。

### Comparable

`public interface Comparable<T>`

- `public int compareTo(T o)`:覆写此方法，即可实现类的自定义排序

### Comparator

“挽救‘’的比较器功能：解决没有使用Comparable排序的类的操作;Arrays中的排序有一种是基于Comparator的排序；

`public interface Comparator<T>`:函数式接口

- `public int compare(T o1,T o2)`

 二者区别：

- java.lang.Comparable是在类定义的时候实现的父接口，主要用于定义排序规则，里面只有一个compareTo的方法
- java.util.Comparator是挽救的比较器操作，需要设置单独的比较器规则实现排序，里面有compara方法。

### 红黑树

本质在节点上追加了一个表示颜色的操作信息（boolean或枚举类）。利用红黑节点实现均衡控制；为了可以进行左旋和右旋操作保证树的平衡；

1. 规则：

- 每个节点都是红色或黑色；
- 根节点必须是黑色；
- 叶子节点是黑色；java中的null表示空节点，而叶子节点为空，所以一般遍历看不到黑色的叶子节点；
- 如果某节点是红色，那么其子节点是黑色；但黑色节点是可以连续的。若黑色节点为N个，则最短路径是连续的N个黑色，树的高度为N-1；最长路径的情况为红黑相间，树的高度为2（N-1）；
- 从一个节点到该节点的子孙节点的所有路径拥有相同数目的黑节点数量；

2. 插入：
   - 所有新节点使用红色进行描述，如果违反规则2改变颜色即可；
   - 如果插入节点的父节点为黑色，不会违反规则。但有如下三种例外就要开始变色和旋转：
     - 插入节点的父节点和叔叔节点均为红色；则将二者涂黑，祖父节点涂红。
     - 插入节点的父节点为红色，叔叔节点为黑色，且插入节点是父节点的左子节点；则将父节点和祖父节点颜色互换，右旋。
     - 插入节点的父节点为红色，叔叔节点为黑色，且插入节点是父节点的右子节点；左旋，则返回到了例外2。

# 3 IO

## File类

java.io.file

1. 基本使用：
   - 构造1：`public File(String pathname)`
   - 构造2：`public File(File parent,File child)`:设置父路径和子目录
   - 创建：`public boolean createNewFile() throws IOException`
   - 存在：`public boolean exists()`
2. 操作深入：
   - 不同系统有不同的文件路径的分隔符：通用表示`File.separator`；
   - 执行同一文件的的重复删除和创建时可能出现延迟问题，所以最好别重名；
   - 获取父路径：`public File getParentFile()`
   - 创建目录：`public boolean mkdirs()`
   - 重命名：`file.renameTo()`
   - 获取文件信息：
     - 文件是否可读：`public boolean canRead()`
     - 获取文件长度：`public long length()`
     - 最后修改日期时间：`public long lastModified()`
     - 判断是否目录/文件：`public boolean is Directory()/isFile()`
     - 列出目录：`public File[] listFiles()`

## IO操作

1. 流处理：

- 字节处理流：
  - **OutputStream**：`public abstract class OutputStream extends Object implements Closeable,Flushable`
    - 输出单个字节数据：`public abstract void write(int b) throws IOException`
    - 输出字节数组数据：`public void write(byte[] b[,int off,int len]) throws IOException`
    - 子类：FileOutputStream类
      - 构造方法：`public FileOutputStream(File file[,boolean append]) throws FileNotFoundException`
  - **InputStream**:`public abstract class InputStream extends Object implements Closeable`
    - 读取单个字节数据：`public abstract int read() throws IOException`
    - 读取一组字节数据：`public abstract int read(byte[] b[,int off,int len]) throws IOException`
    - 子类：FileInputStream类
      - 构造方法：`public FileInputStream(File file) throws FileNotFoundException`
- 字符处理流：
  - **Writer**:`public abstract class Writer extends Object implements Closeable,Appendable,Flushable`
    - 输出字符数组：`public void write(char[] cbuf) throws IOException`
    - 输出字符串：`public void write(String str) throws IOException`
    - 追加：***append***
    - 子类：FileWriter
  - **Reader**：`public abstract class Reader extends Object implements Readable,Flushable`
    - 接收数据,将数据接收到char[]中，返回其长度：`public int read(char[] cbuf) throws IOException`
    - 子类：FileReader

要进行文件的读写操作，则一定通过File找到文件路径；通过流的子类为父类对象实例化(抽象类）；利用流的方法实现数据的输入与输出操作；流的操作属于资源操作，必须关闭处理。

- 二者区别：
  - OutputStream如果没有使用close方法，可以正常输出，但Writer若没有close则无法正常输出，原因在于Writer使用到了**缓冲区**，close后强制使用了刷新。如不close，可使用flush()手动刷新。
  - 二者的基本处理形式是相似的，多数情况时进行数据的传输，所以以字节流(适用于各种类型的文件)为主。

2. *转换流*：

   所谓转换就是讲接收到的字节流向上转型为字符流对象。

   - OutputStreamWriter(extends Writer):`public OutputStreamWriter(OutputStream out)`
   - InputStreamWriter(extends Reader):`public InputStreamWriter(InputStream in)`

3. IO深入操作

- 内存操作流：希望实现IO操作，又不希望产生文件（临时文件）。

  - 字节内存操作流：input表示保存在内存中；ByteArrayOutputStream,ByteArrayInputStream;(extends Out/InputStream)
  - 字符内存操作流：CharArrayWriter,CharArrayReader;

- 管道流：两个线程间的数据发送与接收

  - PipedInputStream,PipedOutputStream;
  - PipedReader,PipedWriter;
    - connect()

- RandomAccessFile:`public RandomAcessFile(File file,String mode) throws FileNotFoundException`

  - mode:r,rw;
  - 最大特点是数据的读取处理上，可以实现数据的跳字节读取：
    - 向下跳：`skipBytes(int n)`;
    - 向回跳：`seek(int n)`

- **打印流**：

  打印流的本质在于提高已有类的功能，比如OutputStream是唯一可以输出的操作标准类，应该以其为核心标准，但其操作功能有限，不方便输出各个数据类型，就可以对它进行包装。

  - **PrintStream**->FilterOutputStream->OutputStream
  - **PrintWriter**->Writer:
    - println()/print()/printf()

- BufferedReader->Reader:解决输入流数据的读取问题；键盘输入标准化；

  - readLine():读取一行数据：+String

  ```java
  BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
  String msg = input.readline();//接收输入数据
  ```

- **Scanner**扫描流:为了替代BufferedReader；

  - `public Scanner(InputStream input)`
  - hasNext([regex]):+boolean 判断是否有数据；
  - next()：+string 取出数据；nextInt：+int
  - useDelimiter(String pattern):+Scanner 设置分隔符；

  ```java
  Scanner scan = new Scanner(System.in)
  ```

  

​	**在以后的开发过程中，程序需要输出数据一定使用打印流，输入数据使用扫描流！**

4. 对象序列化：

   将内存中保存的对象以二进制数据流的形式进行处理，可以实现对象的保存或网络传输；若要序列化对象，必须实现java.io.Serializable接口，此接口并没有任何方法只是描述的是一种类的能力（类似于cloneable）。**必须使用对象数据流**。

- 序列化ObjectOutputStream:

  - `public ObjectOutputStream(OutputStream out)`
  - writeObject()

- 反序列化ObjectInputStream:

  - `public ObjectInputStream(InputStream in)`
  - readObject()

  部分属性可能不需要序列化，可用`transient`关键字修饰属性

# 4 反射

1. **Class类**

   是反射操作的实例化对象， 在定义时可使用泛型进行标记，采用3种方式完成实例化：

   - **Object类**可以根据实例化对象获取class类： `public final Class<?> getClass()`
   - **JVM**支持可通过*类.clas*s获取class类；
   - **Class类支持**`public static Class<?> forName(String ClassName)`

2. Class类方法

   - `newInstance()`相当于`new`:默认调用无参构造*JDK1.9后废除，后面使用`getDeclaredConstructor().newInstance()`*

     `new`的局限性在于在使用的时候需要一个明确的类存在，这在静态工厂设计中不具有动态扩展性。而使用Class方法可根据字符串就可生成相关类。

     ```java
     class Factory{
         private Factory(){}
         @SuppressWarnings("uncheck")
         public static <T>T getInstance(String className,Class<T> clazz){
             T instance = null;
             try {
                 instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return instance;
         }
     }
     ```

     

3. **反射操作**
   - 获取类的基本信息
     - 获取Class名称：`cls.getName()`
     - 获取包名称：`public Package getPackage()`
     - 获取父类：`public Class<? super T> getSuperclass()`
     - 获取父接口：`public Class<?>[] getInterfaces()`
     
   - 构造方法：

     - 所有：`getDeclaredConstructors()/getConstructors()`
     - 指定：`getDeclaredConstructor(Class<?>...params)/getConstructor(Class<?>...params)`

   - 普通方法：

     - 所有：`getMethods()/getDeclaredMethods()`（后者仅获取本类方法，下同）

     - 指定：`getMethod(String name,Class<?>...params):Method`

     - 方法修饰符：`getModifiers():int`;`Modifier.toString(mod)即可返回修饰符名称`

     - 返回值：`getReturnType().getName()`

     - 参数：`getParameterTypes():Class<?> params []`

     - **invoke**:`public Object invoke(Object obj,Object...args)`

       利用反射机制调用方法，可以在不导入指定类开发包的情况下实现属性的配置：1、利用反射获取实例化对象；2、获取指定方法；3、对此方法进行属性设置`method.invoke(obj,value)`

       可避免耦合问题！

   - 调用成员：

     - 成员：`getFields()：Field[]`
     - 指定：`getField(String name):Field`
     - 获取属性内容：`get(Object obj)`
     - 设置属性内容：`set(Object obj,Object value)`
     - *解除封装*：`setAccessible(boolean flag)`
     - **成员类型**：`getType():Class<?>`

   - Unsafe工具类：绕过JVM相关对象管理机制（无法使用JVM内存管理和垃圾回收机制）

4. ClassLoader

   获取类加载器：`getClassLoader:ClassLoader`利用类加载器实现Class反射机制 。

# 5 集合

传统数组固定长度，开发难以大规模应用，最初只能使用两个重要的结构：链表、树；但其存在以下缺点：数据结构代码实现困难；当进行更新处理时候维护麻烦；还要尽可能保证其操作的性能 。

## 集合类

核心接口：Collection/List/Set/Map/Iterator/Enumeratio/Queue/ListIterator

1. *Collection*:

   单值集合操作的最大的父接口，定义了所有单值数据的处理操作

   - **add(E e**):boolean 向集合保存数据（**增加**）
   - addAll(Collection<? extends E> e):boolean 追加一组数据
   - clear():void 
   - contains(Object o):boolean *必须覆写equals()*
   - remove(Object o):boolean *必须覆写equals()*
   - size():int
   - toArray():Object[]
   - **Iterator():Iterator\<E>** 将集合变为Iterator接口（**输出**）
   
2. List:

   `public interface List<E> extends Collection<E> `

   -  get(int index):E 获取指定索引上的数据；
   - set(int index ,E element):E 修改指定索引上的数据；
   - ListIterator():ListIterator\<E> 返回ListIterator接口
   - 三个子类：**ArrayList**/Vector/LinkedList 

3. **ArrayList**

   特点：

    - 保存顺序就是存储顺序；
    - 允许存在重复数据。

   默认无参构造，即在实例化ArrayList对象时没有传递初始化长度，默认情况会使用一个空数组，在扩容的时候发现数组容量不足时，则会判断当前增长的容量和默认容量的大小，使用较大的一个数值作为数组开辟；当ArrayList之中保存的容量不足时会采用成倍的而方式增长，原始为10，则下次为20，类推之；也就是在使用ArrayList需要估算使用的数据量，如果使用超过10个，需要用到有参构造，有参构造为 `public ArrayList(int initialCapacity)`，以防止垃圾数组的产生。

   如果要使用到contains()/remove()方法进行查询与删除的时候，必须成功**覆写equals()**方法

4. LinkedList

   内部实现机制与ArrayList不同，其保存的数据都是利用Node节点进行封装处理，同时为了而提高程序执行性能，每一次都会保存上一个追加的节点，就可以在增加数据的时候避免递归，在增加数据的时候要进行数据保存个数的增加。其实其封装的就是链表的实现。

   ArrayList和LinkedList区别：

   - 前者为数组实现操作，后者为链表实现操作；
   - 在get()获取数据时，前者时间复杂度为1，后者为n；
   - 前者初始化对象数组大小为10，不足会采用2倍的扩充，在保存大数据量是会造成垃圾的产生和性能的下降，于是可以采用后者来保存数据。

5. Vector

   同ArrayList一致，默认开辟一个长度为10的数组，其余实现操作与之事相同的，但不同的是Vectir类中采用的都是synchronized通不处理，而前者并没有进行同步，所以Vector在多线程访问时属于线程安全的，但性能没有ArrayList高。

6. Set接口

   `public interface Set<E> extends Collection<E>`

   实例化：`Set<String> all = Set.of("hello","world","hello")`

   `of`方法是JDK1.9之后的，若集合中存在重复元素会直接抛出异常，所以常规使用一定是依靠子类进行实例化：HashSet/TreeSet

7. **HashSet**

   集合保存的数据时无序的且无重复元素； 方法与collection一致

   `Set<String> all = new HashSet<>()`

   其判断重复元素并不是靠Comparable接口实现，而是利用Object类中的方法实现：

   - 对象编码：`public int hashCode()`
   - 对象比较：`public boolean equals(Object obj)`  

   重复元素的判断利用hashcode进行编码的匹配

8. TreeSet

   有序（升序）；必须实现Comparable接口才能够确认对象的大小关系；其实TreeSet本质就是利用TreeMap子类实现的集合数据的存储；必须将该类中所有的属性依次进行比较，否则在某属性相同时会认为是重复数据。但实际开发中，操作太过繁复，所以一般使用HashSet。

## 集合输出

1. **Iterator**迭代输出

   - 获取Iterator接口对象：`public Iterator<T> iterator()`
   - 判断是否有数据：`hasNext():boolean`
   - 取出数据：`next():T`
   - *删除*：`remove()`

   (*其实Scanner继承于Iterator接口*)

2. ListIterator双向迭代输出

   - 获取接口对象：`public ListIterator<T> ListIterator()`
   - 判断是否有数据：`hasPrevious():boolean`
   - 取出数据：`previous():T`
   - 必须从前往后遍历，才能使用此类从后往前迭代；

3. Enumeration枚举输出

   主要为Vector服务

   - 获取：`public Enumeration <E> elements()`
   - 下一个元素：`hasMoreElement():boolean`
   - 取出：`nextEnumeration():T`

4. foreach输出

   类同于数组中的foreach

## Map

（Key：Value）

1. Map接口：最顶级接口；

   - 定义：`public interface Map<K,V>`
   - **put(K key,V value):V**
   - **get(Object key):V**
   - **entrySet():Set<Map.entry<K,V>>** 将Map转为Set
   - contains(Object key)：boolean
   - keySet():Set\<K> 将Map中的key转为Set
   - remove(Object key):V

   数据不允许重复；常用的子类：HashMap/Hashtable/TreeMap/LinkedHashMap;

2. **HashMap<K,V>**

   ```java
   public HashMap(){this.loadFactor=DEFAULT_LOAD_FACTOR}//0.75f
   ```

   在使用put()进行数据保存时会调用putVal(),同时将key进行hash

   处理，putVal()里提供Node节点类进行数据保存，使用其方法操作过程中会调用resize()进行容量的扩充。

   **put()**:

   - HashMap类中提供“*DEFAULT_INITIAL_CAPACITY*”常量，作为初始大小为16，也就是说默认保存的最大内容为16；
   - 当保存的内容超出阈值（*DEFAULT_LOAD_FACTOR*）就会进行扩充；
   - 在进行扩充时采用成倍的扩充模式，即每次扩充2倍；

   **HashMap工作原理**

   - HashMap中数据存储利用的是Node类，可以使用的数据结构为链表（O(n))、二叉树(O(logn))；
   - JDK1.8开始，HashMap为适应大数据时代，其存储发生了变化，其内部提供一个重要的常量：`TREEIFY_THRESHOLD=8`，当HashMap进行数据存储时，若保存个数未超过阈值8，则使用链表，否则使用红黑树以实现树的平衡；

3. LinkedHashMap

   HashMap无序，此类有序；链表保存，数据一般不要太大；

4. HashTable

   设置的key或value不允许为null，否则出现异常；

   HashMap和HashTable区别：

   - HashMap中的方法都属于异步操作,非线程安全;允许null数据
   - HashTable中的都是同步方法;不允许保存null;

5. Map.Entry内部接口

   所有的key和value都封装在Map.Entry(包装类)ß中；

   - 获取key：getKey():K
   - 获取value：getValue():V

## 工具类

1. Stack类

   `public class Stack<E> extends Vector<E>`

   - 入栈：push(E item):E
   - 出栈：pop():E

2. Queue类

   - 子类1：LinkedList类

   - 追加数据：offer(E e):boolean
   - 获取数据：poll():E 弹出后删除
   - 子类2：PriorityQueue队列（比较功能）

3. Properties类

   与Map集合相似，按照key：value方式存储，但只能存储字符串；

   - setProperties(String key,String value)
   - getProperties(String key,String defaultvalue):不存在返回默认值；
   - 通过输出流输出属性，输入流读取属性  
     - store(outputstream,comment)
     - load(inputstream)

4. Collections工具类

   - Collections.addAll(List\<E> list,args)
   - Collections.reverse(List)
   - Collections.sort(all)->Collections.binarySearch(List,args)

# 6 网络编程

1. TCP

   TCP是最基本的开发模型(可靠网络连接)，其核心是使用两个类实现数据的交互处理：ServerSocket（服务器端），Socket（客户端） ；前者为服务端设置监听操作，后者为客户端寻找服务器端，并为服务器端描述具体客户。

   - ServerSocket：设置服务器监听端口
   - Socket：指明服务器的监听端口

2. BIO处理

   一个服务器启动多个线程，每一个线程单独为每个客户端实现服务支持;

3. UDP

   基于数据报的网络编程实现；客户端是否接收到与发送者无关

   - DatagramPacket：数据内容
   - DatagramSocket：网络发送与接收

# 7 数据库

JDBC用于数据库的连接，有为其提供的模块（java.sql）,里面主要提供DriverManager类(工厂)和若干接口（Statement/Connection/PreparedStatement/ResultSet）;

JDBC的程序数据库的访问有一下形式：

		- JDBC-ODBC桥连接：程序->JDBC->ODBC->数据库（几乎不再使用）
		- JDBC连接：直接进行JDBC进行数据库的连接操作；程序->JDBC->数据库(一般只连续本地数据库服务)
		- **JDBC网络连接**：通过特定网络协议进行数据库连接；程序->JDBC->网络数据库(IP地址和端口号)
		- JDBC协议连接：自己编写协议进行数据库的连接

1. 连接Oracle

   - 准备：
     - 首先启动数据监听服务（Listenrt）、实例服务（SID）
     - 数据库连接的网络地址：jdbc:oracle:thin@主机名称：端口号：SID
     - 数据库的用户名及密码
   - 通过反射机制加载数据库驱动程序：oracle.jdbc.driver.OracleDriver
   - 进行连接：获取Connection接口对象：DriverManager类提供的方法`static getConnection(String url,String user,String password):Connection`  

2. Statement操作

   SQL执行器由Statement接口完成；实现数据的更新与查询操作(可使用sql语句)；

   `public interface Statement extends Wrapper,AutoCloseable`

   每一个SQL操作均为Statement对象，必须利用Connection获取

   - 获取对象：createStatement() :Statement 
   - 更新处理(INSERT,UPDATE,DELETE)：
     - executeUpdate(String sql):int 返回的行数；
   - 查询处理(SELECT...)：
     - executeQuery(String sql):ResultSet    *(restore in RAM)*

   ```java
   				Connection conn = null ;
           Class.forName(oracle.jdbc.driver.OracleDriver);//connect driver
           conn = DriverManager.getConnection(url,user,pwd);
           Statement stmt = conn.createStatement();//create operation statement obj
           String sql = "INSERT INTO ... ";
           int count = stmt.executeUpdate(sql);//update
   				ResultSet rs = stmt.executeQuery(sql);//Query
           conn.close();
   ```

3. PreparedStatement

   Statement中若想实现sql操作，必须用字符串实现sql语句的结构定义，若结合到用户输入数据的情况下可能存在问题；PreparedStatement继承于Statement；

   - 创建对象：prepareStatement(String sql) :PreparedStatement 
   - executeUpdate():int 返回的行数；
   - executeQuery():ResultSet
   - 其sql语句中用"`?`"实现占位,对占位内容进行设置时：对象.setXxx(idx,content)



















​	

