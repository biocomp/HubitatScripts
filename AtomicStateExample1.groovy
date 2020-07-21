definition(
        name: "Atomic state example1 app",
        namespace: "me.biocomp",
        author: "biocomp",
        description: "Testing",
        iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
        iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
        iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)

preferences() {
    section("Update input to dump classes"){
        input "updateMe", "text", title: "Update me", required:true, defaultValue: "One"
        app name: "childApps", appName: "Atomic state example1 state", namespace: "me.biocomp", title: "State app", multiple: false
    }
}

void checkData()
{
    def data = childApps[0].readData()

    log.info("data = ${data}")

    for (def val in 0..getAppends()) {
        for (def c in 'a'..getChars()) {
            def stringToFind = "${c}${val}"
            if (!data.contains(stringToFind)) {
                log.info("queuedData is incomplete - '${stringToFind}' not found in ${data}")
            }
        }
    }

    log.info("Done checking readData()...")
}

def getAppends() { 20 - 1 }
def getChars() { 'f' }

void scheduleAllAppends()
{
    for (def val in 0..getAppends()) {
        runInMillis(1, "appendData${val}")
    }

    runInMillis(2000, checkData)
}

void appendImpl(def num)
{
    for (def c in 'a'..getChars()) {
        threadSafeAppend("${c}${num}");
    }
}

void appendData0() { appendImpl(0) }
void appendData1() { appendImpl(1) }
void appendData2() { appendImpl(2) }
void appendData3() { appendImpl(3) }
void appendData4() { appendImpl(4) }
void appendData5() { appendImpl(5) }
void appendData6() { appendImpl(6) }
void appendData7() { appendImpl(7) }
void appendData8() { appendImpl(8) }
void appendData9() { appendImpl(9) }

void appendData10(){ appendImpl(10) }
void appendData11() { appendImpl(11) }
void appendData12() { appendImpl(12) }
void appendData13() { appendImpl(13) }
void appendData14() { appendImpl(14) }
void appendData15() { appendImpl(15) }
void appendData16() { appendImpl(16) }
void appendData17() { appendImpl(17) }
void appendData18() { appendImpl(18) }
void appendData19() { appendImpl(19) }

void threadSafeAppend(String data) {
    synchronized(mutex) {
        childApps[0].addData(data)
    }
}

@groovy.transform.Field static Object mutex = new Object()

private def update()
{
    unschedule()
    synchronized(mutex) {
        childApps[0].resetData()
    }

    scheduleAllAppends()
}

def installed()
{
    update()
}

def updated()
{
    update()
}


/*
definition(
        name: "Helper app",
        namespace: "me.biocomp",
        author: "biocomp",
        description: "Testing",
        iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
        iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
        iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png"
)
preferences() {
    section("Update input to dump classes"){
        input "updateMe", "text", title: "Update me", required:true, defaultValue: "One"
        input "powerMeters", "capability.powerMeter", title: "Power Meters", multiple: true, required: false
        input "voltages", "capability.voltageMeasurement", title: "Voltages", multiple: true, required: false
        app name: "childApps", appName: "Helper app state", namespace: "me.biocomp", title: "New Child App", multiple: false
    }
}

String getStateUrl() {
    "http://192.168.2.15:8080/apps/api/622/?access_token=44870dab-5b04-4dc8-b7d8-90d6d1faf9cc"
}

void checkData()
{
    //def uri = getStateUrl()
    //log.info("Checking data via '${uri}'...")

    def data = childApps[0].readData()

    log.info("data = ${data}")

    for (def val in 0..getAppends()) {
        for (def c in 'a'..getChars()) {
            def stringToFind = "${c}${val}"
            if (!data.contains(stringToFind)) {
                log.info("queuedData is incomplete - '${stringToFind}' not found in ${data}")
            }
        }
    }

    log.info("Done checking readData()...")
}
def getAppends() { 20 }

def getChars() { 'f' }

void scheduleAllAppends()
{
    for (def val in 0..getAppends()) {
        runInMillis(1, "appendData${val}")
    }

    runInMillis(2000, checkData)
}

void appendImpl(def num)
{
    for (def c in 'a'..getChars()) {
        threadSafeAppend("${c}${num}");
    }
}

void appendData0() { appendImpl(0) }
void appendData1() { appendImpl(1) }
void appendData2() { appendImpl(2) }
void appendData3() { appendImpl(3) }
void appendData4() { appendImpl(4) }
void appendData5() { appendImpl(5) }
void appendData6() { appendImpl(6) }
void appendData7() { appendImpl(7) }
void appendData8() { appendImpl(8) }
void appendData9() { appendImpl(9) }
void appendData10(){ appendImpl(10) }

void appendData11() { appendImpl(11) }
void appendData12() { appendImpl(12) }
void appendData13() { appendImpl(13) }
void appendData14() { appendImpl(14) }
void appendData15() { appendImpl(15) }
void appendData16() { appendImpl(16) }
void appendData17() { appendImpl(17) }
void appendData18() { appendImpl(18) }
void appendData19() { appendImpl(19) }
void appendData20(){ appendImpl(20) }

void threadSafeAppend(String data) {
    synchronized(mutex) {
        childApps[0].addData(data)
    }
}

@groovy.transform.Field static Object mutex = new Object()

private def update()
{
    unschedule()
    synchronized(mutex) {
        childApps[0].resetData()
    }

    scheduleAllAppends()
}

def installed()
{
    update()
}

def updated()
{
    update()
}


*/