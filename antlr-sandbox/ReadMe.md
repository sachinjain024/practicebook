# ANTLR - Another tool for Language Recognition

## Setup

  cd /usr/local/lib
  sudo curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar
  export CLASSPATH=".:/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH"
  alias antlr4='java -jar /usr/local/lib/antlr-4.5.3-complete.jar'
  alias grun='java org.antlr.v4.gui.TestRig'

## Tools
- IntelliJ 12+ Plugin (http://www.antlr.org/tools.html)

## Introduction
- Generates parser classes according to the grammer rules (DSL) provided and Include dynamically generated parser classes in your code
- E.g. For Json, we write JsonParser and grammer is embedded inside code itself.

### Two Steps
1. Generates lexer and parser (antlr4 Graph.g4)
2. Runtime which consumes lexer and parser

## Exercise
- Write grammar for a complex column type e.g.
  
  FreqData {
    orgFreqMap: int -> orgFreqData
  }

  orgFreqData {
    campaignFreqMap: int->camapignFreqData
  }

  campaignFreqData {
    count: int
    mtime: int
  }

- Take input freqData.orgFreqMap[100].orgFreqData[1000].count
- Set the value and read the value should be inputs

## To Evaluate
- How easy is it to use antlr ?
- How to extend or write more code to existing tool ?

## Challenges
- How to validate your grammar ?

## Questions

### How writing your own DSL can be better than using an existing DSL like JSON, ProtoBuf etc ?

## Links
- Repository of Grammars: https://github.com/antlr/grammars-v4
