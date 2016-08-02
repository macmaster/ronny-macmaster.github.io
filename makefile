site:
	cp src/* ./
	rm -rf src

clean:
	mkdir src || echo "src exists"
	cp *.html *.js *.css src
	rm *.html *.js *.css
