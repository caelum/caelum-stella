desc 'Package and upload the release to rubyforge.'
task :release => [:clean, :dist, :package] do |t|
  require 'rubyforge'
  version = APP_VERSION
  name    = APP_NAME
  rubyforge_name = RUBYFORGE_PROJECT
  v = ENV["VERSION"] or abort "Must supply VERSION=x.y.z"
  abort "Versions don't match #{v} vs #{version}" if v != version
  pkg = "pkg/#{name}-#{version}"

  if $DEBUG then
    puts "release_id = rf.add_release #{rubyforge_name.inspect}, #{name.inspect}, #{version.inspect}, \"#{pkg}.tgz\""
    puts "rf.add_file #{rubyforge_name.inspect}, #{name.inspect}, release_id, \"#{pkg}.gem\""
  end

  rf = RubyForge.new
  puts "Logging in"
  rf.login

  c = rf.userconfig
  c["release_notes"] = APP_DESCRIPTION if Object.const_defined?("APP_DESCRIPTION")
  c["release_changes"] = APP_CHANGES   if Object.const_defined?("APP_CHANGES")
  c["preformatted"] = true

  files = ["#{pkg}.tar.gz", "dist/#{name}-#{version}.js"].compact

  puts "Releasing #{name} v. #{version}"
  rf.add_release rubyforge_name, name, version, *files
end
