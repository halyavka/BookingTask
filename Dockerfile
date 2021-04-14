FROM adoptopenjdk/openjdk11:alpine

USER root

CMD ["gradle"]

ENV GRADLE_HOME /opt/gradle

RUN set -o errexit -o nounset \
    && echo "Adding gradle user and group" \
    && addgroup -S -g 1000 gradle \
    && adduser -S -u 1000 -G gradle -h /home/gradle -D gradle

RUN mkdir /home/gradle/.gradle \
    && chown --recursive gradle:gradle /home/gradle \
    && echo "Symlinking root Gradle cache to gradle Gradle cache" \
    && ln -s /home/gradle/.gradle /root/.gradle

RUN apk --no-cache add gradle

RUN  mkdir -p /opt/xunit /opt/jenkins \
    && chown gradle:gradle /opt/xunit /opt/jenkins

USER gradle

ADD --chown=gradle:gradle build/docker /home/gradle/tests
WORKDIR /home/gradle/tests

#COPY src/test/suite.xml .

ENTRYPOINT ["gradle", "--no-daemon", "--stacktrace", "-x", "classes", "--max-workers", "8", "-x", "testClasses", "--offline"]
CMD ["test"]
