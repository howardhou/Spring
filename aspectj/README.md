# AspectJ 框架
- download URL ： https://www.eclipse.org/aspectj/downloads.php#stable_release
- 执行命令安装： java dongdong$ java -jar aspectj-1.9.1.jar 
		
- 添加环境变量 for MacOS： 
	- `export AJ_HOME=/Users/dongdong/Applications/aspectj1.9/bin`
	- `export PATH=${PATH}:$AJ_HOME/bin`
	- 将 aspectjrt.jar [复制到 /Library/Java/Extensions 目录中](https://stackoverflow.com/questions/1675765/adding-to-the-classpath-on-osx) ： 解决 classpath error: unable to find org.aspectj.lang.JoinPoint (check that aspectjrt.jar is in your classpath) 错误
	
## TxAspect
- 编译： `ajc -d . Hello.java TxAspect.java `
- 执行 Hello.class： `java com.example.Hello `

## LogAspect
- 编译： `ajc -d . *.java `
- 执行： `java com.example.Hello `