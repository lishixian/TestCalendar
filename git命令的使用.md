## 快速参考

```java

// 本地建立git仓库
git init

// 从github下载代码
git clone git@github.com:xxx/xxx.git

// 本地代码关联github库:
git remote add origin https://github.com/xxx/xxx

// pull代码到本地
git pull origin master

// 添加一个名为host的分支
git checkout -b host xxxxx

// 切换到主干
git checkout master 

// 合并分支host到主干
git merge host 
git commit -m “描述”

 // 把本地源码库push到Github上,在master分支可以这么写
git push origin master
// 如果是其他自建分支,需要指定主分支master提交
git push origin HEAD:master
// 或者 git push origin HEAD:refs/for/master

```