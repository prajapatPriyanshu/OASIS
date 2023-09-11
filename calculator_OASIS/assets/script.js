// This function clear all the values
function clearScreen() {
    document.getElementById("result").value = "";
}
 
// This function display values
function display(value) {
    document.getElementById("result").value += value;
}
 
// This function evaluates the expression and returns result
function calculate() {
    var p = document.getElementById("result").value;
    var q = eval(p);
    document.getElementById("result").value = q;
}

// This function delets the last entered value
function delLast(){
    var x = document.getElementById("result").value;
    var y = x.slice(0,-1);
    document.getElementById("result").value = y;
}

// This function manages brackets in the expression
function displayBracket(){
    var x = document.getElementById("result").value;
    if(x.charAt(x.length-1)=='('){
        delLast();
        delLast();
    }
    else if(x.charAt(x.length-1)=='/' || x.charAt(x.length-1)=='*' || x.charAt(x.length-1)=='-' || x.charAt(x.length-1)=='+' || x.length==0){
        document.getElementById("result").value += '(';
    }
    else{
        var temp = false;
        for(var i=x.length-1;i>=0;i--){
            if(x.charAt(i)=='('){
                temp = true;
                break;
            }
            else if(x.charAt(i)==')'){
                break;
            }
        }
        if(temp==true){
            document.getElementById("result").value += ')';
        }
        else{
            document.getElementById("result").value += '*(';
        }
    }
}