jQuery.fn.extend({
  mask : function(){
    var cpfFields = $('.cpf');
    cpfFields.each(function(){
      $(this).attr('maskString', '###.###.###-##');
      $(this).format(this);
    });
    cpfFields.keypress(function(event){
      $(this).doMask(this, event.which);
    });
    var cnpjFields = $('.cnpj');
    cnpjFields.each(function(){
      $(this).attr('maskString', '##.###.###/####-##')
      $(this).format(this);
    });
    cnpjFields.keypress(function(event){
      $(this).doMask(this, event.which)
    });
    var rgFields = $('.rg');
    rgFields.each(function(){
      $(this).attr('maskString', '##.###.###-#');
      $(this).format(this);
    })
    rgFields.keypress(function(event){
      $(this).doMask(this, event.which);
    })
  },
  
  doMask : function(element, keyCode){
    var input = $(this);
    var size =  input.val().length;
    var mask = input.attr('maskString');
    $(input).attr('maxLength', mask.length);
    // cuida de backspace
    if(keyCode != 8 && mask.charAt(size) != '#'){
        input.val(input.val() + mask.charAt(size)); 
    }
  },
  
  format : function () {
    var input = $(this);
    var mask = $(this).attr('maskString');
    // o campo esta populado com o tamanho esperado
    if(input.val().length == mask.replace(/[^#]/g, '').length){
      var temp = input.val().split('');
      var formattedValue = '';
      var valueIndex = 0;
      for(var size in mask){
        formattedValue += mask.charAt(size) != '#' ? mask.charAt(size) : temp[valueIndex++];
      }
      $(input).val(formattedValue);
    }
  }
})