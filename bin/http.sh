#!/usr/bin/env bash

# JVM
JAVA_HOME=${JAVA_HOME:-/global/share/jdk1.8.0_191}
JVM_MEMORY="-Xmx1g \
  -Xms1g \
  -Xss1m \
  -XX:MetaspaceSize=1g \
  -XX:MaxMetaspaceSize=1g"
JVM_GC="-XX:+UseG1GC \
  -XX:MaxGCPauseMillis=200"
JVM_JDWP="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address="
JVM_ARGS=${JVM_MEMORY}" "${JVM_GC}

function check_process_is_running(){
    if [[ -f service.pid ]]; then
        pid=`cat service.pid`
        ps ${pid} > /dev/null 2>&1
        return $?
    fi
    return 1
}

command=$1
case ${command} in
    (start)
        check_process_is_running
        if [[ $? -eq 0 ]]; then
            echo "Service[pid="`cat service.pid`"] already started, stop it first or delete service.pid"
            exit 11
        fi
        if [[ -z "$JAVA_HOME" ]]; then
            echo "Error: JAVA_HOME is not set."
            exit 111
        fi

        EXEC_JAR=$2
        shift 3

        # copy as *.running
        RUNNING_JAR=${EXEC_JAR}.running
        cp ${EXEC_JAR} ${RUNNING_JAR}
        chmod +x ${RUNNING_JAR}

        # jdwp
        #jdwp端口号，0为默认不开启
        DEBUG=1234
        if [[ $DEBUG -ne 0 ]]; then
          JVM_JDWP=${JVM_JDWP}${DEBUG}
          echo "Enable jdwp = "${JVM_JDWP}
          JVM_ARGS=${JVM_ARGS}" "${JVM_JDWP}
        fi

        JAVA="$JAVA_HOME/bin/java -server"
        RUN_COMMAND="$JAVA $JVM_ARGS -jar $RUNNING_JAR $@"

        echo "Starting service..."
        echo "Command = [" ${RUN_COMMAND} "]"
        if [[ ${FOREGROUND} -eq 1 ]]; then
          echo "Running in foreground"
          ${RUN_COMMAND}
        else
          echo "Running in background"
          nohup ${RUN_COMMAND} >/dev/null 2>&1 &
          echo $! > service.pid
          exit 0
        fi
     ;;
    (stop)
        check_process_is_running
        if [[ $? -eq 0 ]]; then
            echo "Stopping service[pid=$pid]..."
            kill ${pid}
            if [[ $? -eq 0 ]]; then
              rm service.pid
              echo "Stopped"
            else
              echo "Error: kill failed, return=$?"
            fi
        else
            echo "No service is running or service.pid is deleted"
        fi
     ;;
    (*)
        echo Unsupported operation: ${command}
        usage
     exit 9
   ;;
esac
