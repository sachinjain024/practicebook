grammar Graph;
graph: 'Graph {' edge+ '}';
vertex: ID;
edge: vertex '->' vertex '(' NUM ')' ;
ID: [a-zA-Z]+;
NUM: [0-9]+;
WS: [ \t\r\n]+ -> skip;