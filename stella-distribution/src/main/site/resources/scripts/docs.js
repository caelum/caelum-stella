window.addEvent('domready', function() {

  $$('.MGroupContent').setStyle('display', 'block');

  var selected = $('MSelected');

  var current = (selected) ? selected.getParent() : false;

  $$('div.MGroup').each(function(div) {
    var link = div.getElement('a');
    var block = link.getNext();

    var fx = new Fx.Slide(block);

    if (block != current) fx.hide();

    link.addEvent('click', function() {
      fx.toggle();
    });

  });

  $$('.CTitle').each(function(heading) {
    new Element('a', {
      'href': '#MainTopic',
      'class': 'toTop'
    }).setHTML('top').injectBefore(heading.getFirst());
  });

  new SmoothScroll();

});

document.write('<style type="text/css" media="screen">div.MGroupContent{display: none}</style>');