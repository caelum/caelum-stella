stella.onLoad = function(callback){
  Event.observe(window, 'load', function(event) {
    callback(event);
  });
};

stella.find = function(selector){
  return $$(selector);
} 