build: framework-jar build-classes build-avms

build-classes:
	docker-compose run --rm maven mvn clean install

build-avms:
	docker-compose run --rm --entrypoint "/bin/sh" neoj scripts/build-avms.sh

test: submodules
	docker-compose run --rm maven mvn test

framework-jar: update-submodules
	docker-compose run --rm neo-devpack-java mvn clean install && \
	cp vendor/neo-devpack-java/target/*.jar ./vendor/org.neo.smartcontract.framework.jar

update-submodules:
	git submodule update --init --recursive --remote .

.PHONY: build build-classes build-avms test framework-jar update-submodules
