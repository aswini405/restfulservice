export LD_LIBRARY_PATH=/svc/lib/

echo "lib path"
echo LD_LIBRARY_PATH


java -Djava.library.path=/svc/lib $JAVA_OPTS -jar /svc/jar/queryservice-1.0.5.jar com.ge.hc.ccs.edge.queryservice.Application