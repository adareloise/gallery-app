$(function validate() {
	
	var contact_validate = {
		
		rules: {
		      name: {
		        required: true,
		      },
		      email: {
		        required: true,
  		      	email: true,
		      },
			  subject: {
		        required: true
		      },
		      content: {
		        required: true
		      }
		    },

		messages:{
		      name: {
		        required: "Ingrese nombre"
		      },
		      email: {
		        required: "Ingrese Mail",
				email: "Ingrese un email valido"
		      },
			  subject: {
		        required: "Ingrese un motivo"
		      },
		      content: {
		        required: "Ingrese un mensaje"
		      },
			}	  
	 	};
		
	 $('#contact').validate(contact_validate);

  });