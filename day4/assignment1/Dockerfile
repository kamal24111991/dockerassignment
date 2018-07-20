FROM alpine
MAINTAINER Kamal Aggarwal
RUN apk update
RUN apk add nodejs
RUN mkdir -p /app
RUN mkdir -p /kamal
COPY index.js /app
WORKDIR /app
CMD node index.js

