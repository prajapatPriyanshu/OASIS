function ShowHide(id){
    const cars = ["home","about","clubs","trophies","records"];
    var c = document.getElementById(id);
    var d = document.getElementById(cars[0]);
    if(d==c){
        for(var i=0;i<cars.length;i++){
            var m = cars[i] + "button";
            var n = document.getElementById(m);
            var x = document.getElementById(cars[i]);
            n.style.color = "bisque"
            x.style.display = "block";
        }
        var n = document.getElementById('homebutton');
        n.style.color = "white";
    }
    else{
        for(var i=0;i<cars.length;i++){ 
            var y = document.getElementById(cars[i]);
            var m = cars[i] + "button";
            var n = document.getElementById(m);
            if(y==c){
                y.style.display = 'block';
                n.style.color = "white";
            }
            else{
                y.style.display = 'none';
                n.style.color = "bisque"
            }
        }
    }

}