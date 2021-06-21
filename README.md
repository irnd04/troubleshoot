
- https://docs.oracle.com/en/java/javase/11/troubleshoot/index.html
- https://geekflare.com/important-jvm-options/
- https://www.oracle.com/java/technologies/javase/vmoptions-jsp.html
- https://fastthread.io/
- https://www.eclipse.org/mat/

## Thread Dump을 뜰때 추가적인 정보들도 같이 요청할 수 있다.
### -XX:+PrintConcurrentLocks 
`jstack -l pid와 동일`
### -XX:+PrintClassHistogram
`jmap -histo pid와 동일`

## Thread Dump 뜨기
`jstack pid`

## Linux에서 Thread상태보기
`ps -Lf -p pid`

## 에러 발생시 스크립트 실행
`-XX:OnError="{script}"`
`-XX:ErrorFile="{scriptFile경로}"`

## Heap Dump 뜨기
`jmap -dump:format=b,file=heapdump.bin pid`

## Core Dump 뜨기
`gcore -o heap.bin.core pid`

## Core Dump -> Heap Dump
`jmap -dump:format=b,file=headump.bin /usr/local/java/bin/java heap.bin.core`
`jmap 옵션 자바실행파일위치 코어덤프위치`

## 에러 발생시 Heap Dump 생성
`-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=경로(파일명아님)`

## 메모리 지정
`-Xms128m -Xmx128m`

## 인코딩
`-Dfile.encoding=UTF-8`

## gc logging
es : `-Xlog:gc*,gc+age=trace,safepoint:file=logs/gc.log:utctime,pid,tags:filecount=32,filesize=64m`<br/>
`-Xlog:gc*,gc+age=trace,safepoint:file=logs/gc.log:time,level,pid,tags:filecount=32,filesize=64m`
