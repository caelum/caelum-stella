TEST_CHANGES_SINCE = Time.now - 600

namespace :test do
  namespace :recent do
    desc "Open recently modified files into browser"
    task :javascript do
      require 'rubygems'
      gem 'activesupport'
      require 'active_support'

      since = TEST_CHANGES_SINCE
      touched = FileList[
        'test/unit/*_test.html', 
        'src/*.js'].select { |path| File.mtime(path) > since }
      next if touched.blank?
      
      gem 'newjs'
      require 'newjs'
      require 'newjs/autotest'
      
      touched.each do |file|
        if file =~ /\/([^\/]+)\.js$/
          file = "test/unit/#{$1}_test.html"
        end
        file = "#{APP_ROOT}/#{file}"
        unless File.exists?(file)
          # puts "Notice: Test file does not exist: #{file}"
          next
        end
        puts "Launching test: #{file}"
        browsers = JavascriptTestAutotest::Config.get :browsers
        if browsers.blank?
          puts "WARNING: No browsers setup in config/javascript_test_autotest.yml"
          next
        end
        browsers.each_pair do |name, path|
          browser = JavascriptTestAutotest::Browser.browser(name, path)
          browser.setup
          browser.visit(file)
          browser.teardown          
        end
      end
    end
  end
end
