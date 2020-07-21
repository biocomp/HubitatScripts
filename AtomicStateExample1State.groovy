definition(
    name: "Atomic state example1 state",
    namespace: "me.biocomp",
    author: "biocomp",
    description: "Testing",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    parent: "me.biocomp:Atomic state example1 app",
)

preferences() {
    page(title: "Title", name: "Default", install: true) {
        section() {
            paragraph "There's no settings here"
        }
    }
}

void resetData() {
    atomicState.queuedData = ""
}

String readData() {
    return atomicState.queuedData
}

def addData(String data) {
    def oldData = atomicState.queuedData
    def newData = oldData + data
    atomicState.queuedData = newData

    log.info "+'${data}' | Updated: '${oldData}' -> '${newData}'"
}

def installed() {
    resetData()
}

def updated()  {
    resetData()
}


/*
definition(
        name: "Helper app state",
        namespace: "me.biocomp",
        author: "biocomp",
        description: "Testing",
        iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
        iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
        iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
        parent: "me.biocomp:Helper app",
        oauth: true
)

void resetData() {
    atomicState.queuedData = ""
}

String readData() {
    return atomicState.queuedData
}

def getUri() {
    log.info("getUri called")
    return state.uri
}

def addData(String data) {
    def oldData = atomicState.queuedData
    def newData = oldData + data
    atomicState.queuedData = newData

    log.info "+'${data}' | Updated: '${oldData}' -> '${newData}'"
}

def installed() {
    if(!state.accessToken){
        //enable OAuth in the app settings or this call will fail
        createAccessToken()
    }

    resetData()
}

def updated()
{
    resetData()
}


*/