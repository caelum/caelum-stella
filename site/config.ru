require 'static_server'

run StaticServer.configure
#{|map|
#    map.redirect '/google' => 'http://www.google.com'
#    map.forward '/index' => 'index.html'
#}
