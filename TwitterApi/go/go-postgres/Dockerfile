FROM amd64/golang:1.16


# Set the Current Working Directory inside the container
WORKDIR /app/go-postgres

# We want to populate the module cache based on the go.{mod,sum} files.
COPY go.mod .
COPY go.sum .

RUN go mod download

COPY .. .

# Build the Go app
RUN go build -o ./out/go-postgres .


# This container exposes port 8080 to the outside worlds
EXPOSE 8500

# Run the binary program produced by `go install`
CMD ["./out/go-postgres"]