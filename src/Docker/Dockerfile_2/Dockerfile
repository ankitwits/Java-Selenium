FROM alpine:latest
RUN apk add openjdk8
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin
WORKDIR /usr/share/practicetest
ADD SquareValue.java SquareValue.java
ENTRYPOINT javac SquareValue.java && java SquareValue
