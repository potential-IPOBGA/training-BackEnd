#使用JDK11环境作为基础镜像
FROM openjdk:11

#拷贝文件并且重命名
ADD build/libs/final-0.0.1-SNAPSHOT.jar finalquiz.jar

# 指定容器需要映射到主机的端口
EXPOSE 8080

#容器启动时执行的指令
ENTRYPOINT ["java", "-jar", "/app.jar"]
