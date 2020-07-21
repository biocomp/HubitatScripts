package me.biocomp.hubitat_ci_example

import me.biocomp.hubitat_ci.app.HubitatAppSandbox
import spock.lang.Specification

class AtomicStateExample1Test extends Specification {
    HubitatAppSandbox sandbox = new HubitatAppSandbox(new File("AtomicStateExample1.groovy"))

    def "Basic validation"() {
        expect:
            sandbox.run()
    }
}

class AtomicStateExample1StateTest extends Specification {
    HubitatAppSandbox sandbox = new HubitatAppSandbox(new File("AtomicStateExample1State.groovy"))

    def "Basic validation"() {
        expect:
            sandbox.run()
    }
}