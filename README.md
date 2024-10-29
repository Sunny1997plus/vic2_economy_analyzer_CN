# 维多利亚II（Victoria II）存档经济分析器（中文版）

代码原作为[Nashetovich](http://oldforum.paradoxplaza.com/forum/showthread.php?715468)。
后由[Anton Krylov](https://github.com/aekrylov/vic2_economy_analyzer)完善并上传。

此版本基于**Anton Krylov**版本，主要工作如下：
1. 完成简体中文本地化。（部分描述可能不准确，需后续订正）
2. 更改了在查阅本地化过程中，本地化文件的导入编码。采用了中国大陆常用的GBK。
3. 修改了表格、饼图的键名。目前这些都会显示本地化名称，而非代码。

缩减工作：
1. 未针对Linux平台进行本地化开发。

## 用法

运行环境：Java 8及以上。

1. 下载[最新版本](https://github.com/Sunny1997plus/vic2_economy_analyzer_CN/releases)。
2. 运行主程序`vic2-sgea.exe`，位于文件夹根目录。
3. 填写`存档路径`（应当是.v2文件）、`游戏路径`（应当是包含VictoriII主程序的文件夹）、`Mod路径`（应当是游戏模组的主文件夹）。
   **特别注意**：无论是否加载了模组，`Mod路径`都必须填写一个路径。（否则会报错）
   如果存档没有使用任何模组，`Mod路径`推荐填写一个空文件夹。
4. 单击`加载`按钮，导入存档和游戏数据。

提示：
1. 可以通过点击选项卡右侧的**＋**，来启用或关闭选项卡。选项卡亦能拖动。
2. 双击表格中，单个选项，可以获得饼图。将光标放到饼图上可以看到细节。
3. 执行过程中，如果遇到窗口过大的问题，可以用`Alt`+`Space`来最大化获得标题栏。随后拖动标题栏，将窗口放到期望的位置，并进行缩放。

## 如何构建项目

环境配置：
1. Java 8以上的环境。需要Java Development Kits。
2. 需要Wix程序。
3. 需要gradle。

构建：
1. 在项目根目录下，通过命令行运行`gradle run`。
   此过程会完成编译，并弹出程序窗口。但尚未链接。
2. 在项目根目录下，通过命令行运行`gradle jpackage`。
   此过程将会将上次运行的镜像链接，打包成主程序。放置在`build/dist`文件夹中。 (此过程不需要JVM)

## 运行问题
- **java.lang.NullPointerException**

    如果是在点击`加载`过程中弹出错误，请再次确认，你是否填写了**全部**三个路径？

- **Can't load large late game file**

    使用文本编辑的方式，打开`.\runtime\bin\Vic2-SGEA.bat`。
    设置`-Xmx`后面的数字。这将会使程序申请更多内存空间。`-Xmx1500m`对绝大多数机器应当都够用了。
    
    需要注意，这个值设置得过大，可能会导致操作系统不稳定。
 
## 数值问题

1. 目前，金矿的计算较为粗糙：金矿收入＝金矿产量×价格（HoD默认是8）。然而，真实的金矿计算方式是：
   国库直接获得的金矿收入：金矿产量×倍率（写在defines.lua，GOLD_TO_CASH_RATE，HoD默认是0.5）；
   RGO金矿收入：金矿产量×价格×倍率（写在defines.lua，GOLD_TO_WORKER_PAY_RATE，HoD默认是3.5）。

## 计划（可能短期内不做）

- [ ] 整理饼图的本地化代码，避免出现关键字引用错误。
