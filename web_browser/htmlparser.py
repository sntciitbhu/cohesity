from htmlgrammar import *
from htmllexer import *

# defined the closure function to get new grammar matching lists from grammar in the chart
#grammar is our grammar
#i is the index of current chart
#x is the type of current state eg: elt or html
#ab is the rule that is traversed uptill now eg: if in rule 'html',['elt','html'] we have traversed till 'elt' then ab is ['elt']
#cd is the remaining part of the rule

def closure(grammar,i,x,ab,cd): 
    if cd == []:
        return []
    new_states = []
    for rule in grammar:
        if rule[0] == cd[0]:
            if rule != ("html",[]):
                k=[cd[0]] #k is the tree created for this state
            new_states = new_states + [[(rule[0],[],rule[1],i),k]]
    return new_states

# defined shift to see if the element is a token so as to add that state to the next chart[i]
#tokens are the list of tokens we have from the web page
#i is the index of current chart or the index uptill which the tokens have been traversed and we have to traverse the ith token
#x is the type of current state eg: 'elt' or 'html'
#ab is the rule that is traversed uptill now eg: if in rule 'html',['elt','html'] we have traversed till 'elt' then ab is ['elt']
#cd is the remaining part of the rule
#k is the tree of the state we are using shift for
def shift(tokens,i,x,ab,cd,j,k):
    if cd!=[] and (tokens[i])[0]==cd[0]:
        k = k+[tokens[i]]  # adding the token to the tree
        return [(x,ab+[cd[0]],cd[1:],j),k]
    else:
        return None

#defined reductions to get the previous states that wanted the expression apearing the current chart[i]
#chart is the chart of all states
#i is the index of current chart
#x is the type of current state eg: 'elt' or 'html'
#ab is the rule that is traversed uptill now eg: if in rule 'html',['elt','html'] we have traversed till 'elt' then ab is ['elt']
#cd is the remaining part of the rule
#j is the index of chart from which this current state has came
#k is the tree of current state we are reducing
def reductions(chart,i,x,ab,cd,j,k):
    new_states = []
    if cd != []:
        return []
    for jstate in chart[j]:
        if (jstate[0])[2] != [] and ((jstate[0])[2])[0] == x:   
            jstate[1] = jstate[1] + [k]
            new_states = new_states + [[((jstate[0])[0],(jstate[0])[1]+[x],((jstate[0])[2])[1:],(jstate[0])[3]),jstate[1]]]
    return new_states

#defined addtochart to add unique states to chart so that there is no redundancy
def addtochart(chart,index,state):
    #making a list of states in the chart[i] without their tree
    t=[m[0] for m in chart[index]]
    #checking current state without tree if not in chart adding it
    if not (state[0] in t):
        chart[index] = chart[index] + [state]
        return True
    return False

#defining traverse function to traverse the tree and eliminating duplicates and getting tree in desired format
def traverse(tree):
    while(['html'] in tree):
        tree.remove(['html']) #removing the empty html subtrees generated by rule ['html',[]]
    #calling function recusively so that empty html subtrees can be deleted from every tree
    for m in tree:
        if type(m) == list:
            traverse(m)

#defining parse function to parse the given webpage tokens generated by lexer   
def parse(tokens,grammar):
    tokens = tokens + [("end","")]#adding end token to the list of tokens generated
    chart = {} 
    ast =["html",] #creating start state of the tree
    start_rule = grammar[0]
    for i in range(len(tokens)+1):
        chart[i]=[] #specifying that chart is a dictionary of lists
    start_state = [(start_rule[0],[],start_rule[1],0),ast] #specifying starting state
    chart[0] = [start_state]
    for i in range(len(tokens)): #traversing every state of chart corresponding to every token except end token
        while True:
            changes = False
            for state in chart[i]:
                #x is the type of current state eg: 'elt' or 'html'
                #ab is the rule that is traversed uptill now eg: if in rule 'html',['elt','html'] we have traversed till 'elt' then ab is ['elt']
                #cd is the remaining part of the rule
                #j is the state from where it came
                #k is the tree of current state
                x=(state[0])[0] 
                ab=(state[0])[1]
                cd=(state[0])[2]
                j=(state[0])[3]
                k=state[1]
                #getting next states and adding them to chart
                next_states = closure(grammar,i,x,ab,cd)
                for next_state in next_states:
                    changes = addtochart(chart,i,next_state) or changes
                next_state = shift(tokens,i,x,ab,cd,j,k)
                if next_state != None:
                    any_changes = addtochart(chart,i+1,next_state) or any_changes #shift is done at i+1 index
                next_states = reductions(chart,i,x,ab,cd,j,k)
                for next_state in next_states:
                    changes = addtochart(chart,i,next_state) or changes
            if not changes:
                break
    #defining accepting state to check wether the whole set of tokens is according to rule of grammar
    accepting_state = (start_rule[0],start_rule[1],[],0)
    final_states = [state[0] for state in chart[len(tokens)-1]]
    for states in chart[len(tokens)-1]:
        if states[0]==accepting_state:
            ast = states[1]#getting the final tree created
    traverse(ast) #geting ast (abstract syntax tree) into desired format
    return (accepting_state in final_states,ast)

#list of tokens from our tokens from lexer
tokk=[]
while True:
    tok = htmllexer.token()
    if not tok:
        break
    tokk=tokk+[(tok.type,tok.value)]
#checking for syntax
try:
    result = parse(tokk,grammar)
    if not result[0]:
        raise Exception("Syntax error")
    else:
        ast = result[1]
except:
    raise