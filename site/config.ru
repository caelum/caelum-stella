run Proc.new{ |env|
  if env["PATH_INFO"] == '/'
    [302, {"Location" => "/index.html", "Content-Type" => "text/html"}, []]
  else
    Rack::File.new(".").call(env)
  end
}

