run Proc.new{ |env|
  if env["PATH_INFO"] == '/'
    #[302, {"Location" => "/index.html", "Content-Type" => "text/html"}, []]
    env["PATH_INFO"] = 'index.html'
  end
  
  Rack::File.new("./public").call(env)
}

