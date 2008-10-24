Stella.Masker = function(){
  this.cpfFields = jQuery(':text.cpf');
  this.cpfFields.each(function(){
    this.mask = ['#','#','#','.','#','#','#','.','#','#','#','-','#','#'];
  });
  this.cnpjFields = jQuery(':text.cnpj');
  this.cnpjFields.each(function(){
    // 00.000.000/0000-00
    // 12345678901234
    this.mask = ['#','#','.','#','#','#','.','#','#','#','/','#','#','#','#','-','#','#'];
  });
};

Stella.Masker.prototype.mask = function(){
  this.cpfFields.keypress(function(event){
    Stella.Masker.cpf(this, event);
  });
  this.cpfFields.each(function(){
    Stella.Masker.cpfWithDefinedValue(this);
  });
  this.cnpjFields.keypress(function(event){
    Stella.Masker.cnpj(this, event);
  });
  this.cnpjFields.each(function(){
    Stella.Masker.cnpjWithDefinedValue(this);
  });
};

Stella.Masker.cpf = function(field, keyEvent){
  var input = jQuery(field);
  var isBackspace = false;
  var size =  input.val().length;
  var mask = field.mask;
  jQuery(input).attr('maxLength', mask.length);
  
  var kp = keyEvent.which || keyEvent.keyCode; 
  if(kp == 8){
    isBackspace = true;
  }

  if(!isBackspace){
    if(mask[size] == '.' || mask[size] == '-'){
      jQuery(input).val(input.val() + mask[size]);
    } 
  }
}

Stella.Masker.cpfWithDefinedValue = function(field){
    var input = jQuery(field);
    var isBackspace = false;
    var size = input.val().length;
    var mask = field.mask;
    if(size >= 11){
      jQuery(input).attr('maxLength', mask.length);
      if(!isBackspace){
        var temp = [];
        temp = input.val().split('');
        var newInput = '';

        var valueIndex = 0;
        for(var size in mask){
          newInput += mask[size] == '.' || mask[size] == '-' 
                      ? mask[size]
                      : temp[valueIndex++];
        }
        jQuery(input).val(newInput);
    }
  }
}

Stella.Masker.cnpj = function(field, keyEvent){
  var input = jQuery(field);
  var isBackspace = false;
  var size =  input.val().length;
  var mask = field.mask;
  jQuery(input).attr('maxLength', mask.length);
  
  var kp = keyEvent.which ||keyEvent.keyCode;
  if(kp == 8){
    isBackspace = true;
  }
  
  if(!isBackspace){
    if(mask[size] == '.' || mask[size] == '-' || mask[size] == '/'){
      jQuery(input).val(input.val() + mask[size]);
    }
  }
}

Stella.Masker.cnpjWithDefinedValue = function(field){
  var input = jQuery(field);
  var isBackspace = false;
  var size = input.val().length;
  var mask = field.mask;
  jQuery(input).attr('maxLength', mask.length);
  if(size >= 14 ){
    if(!isBackspace){
      var temp = [];
      temp = input.val().split('');
      var newInput = '';
      var valueIndex = 0;

      for(var size in mask){
        newInput += mask[size] == '.' || mask[size] == '-' || mask[size] == '/'
                    ? mask[size]
                    : temp[valueIndex++];
      }
      jQuery(input).val(newInput);    
  }
}
  
}