grammar Selector ;

@header {
package selector;
}

entry: selector EOF ;
selector: pathComponent | pathComponent PERIOD selector '\n' ;
pathComponent: fieldWithIndex | field ;
field: FIELDNAME ;
fieldWithIndex: FIELDNAME LBRACKET INDEX RBRACKET ;
LBRACKET: '[' ;
RBRACKET: ']' ;
PERIOD: '.' ;
FIELDNAME: [a-zA-Z]+ ;
INDEX: [0-9]+ ;
WS: [ \t\r\n]+ -> skip ;

// grun Selector input -gui
// { a.b[0].c.d }