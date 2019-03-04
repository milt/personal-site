.phony: clean site

clean:
	rm -rf docs/site.js docs/css
docs/css:
	cp -rv resources/public/css docs/css
docs/site.js:
	clojure -A:fig:min
site: clean docs/css docs/site.js
