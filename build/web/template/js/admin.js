//them class neu chua co
	function addClassShow(id) {
		document.getElementById(id).classList.toggle("show");
		// body...
	}
	var button = document.getElementsByClassName('dropdown-btn');
	var content= document.getElementsByClassName('dropdown-content');
	for(var i = 0;i < button.length;i++){
		button[i].addEventListener("click", function(){
			var id = this.value;
			for (var i = 0; i < content.length; i++) {
	            content[i].classList.remove("show");
	        }
			addClassShow(id);
		});
	}
	window.addEventListener("click", function(){
		if(!event.target.matches('.dropdown-btn'))
			for (var i = 0; i < content.length; i++) {
                content[i].classList.remove("show");
             }
	});
	var buttons = document.getElementById('bar-menu-out');
	var contents= document.getElementById("bar-menu-out-result");
	var close  = document.getElementById("close");
	
	buttons.addEventListener("click", function(e){
		e.preventDefault();
		document.getElementById('bar-menu-out-result').classList.toggle("out");
		
	});

	close.addEventListener("click", function(e){
			e.preventDefault();
			contents.classList.remove("out");
			
		});