def test = sh(script: 'for rs in \$(find ./bash/ -type f \\( -iname \"*.ruleset\" ! -iname \"*.strict.ruleset\" \\)); do OUTPUT=\"\$(cat $rs)\n\$OUTPUT\"; done && echo $OUTPUT', returnStdout: true)
println "TEST: ${test}"

def cmd = "sleep 10 && echo test && exit 0"
def bPID = sh(script: "eval ${cmd} 2>&1 > output.log &; echo $!", returnStdout: true)
println "PID: ${bPID}"
sh "wait ${bPID} && echo $?"
