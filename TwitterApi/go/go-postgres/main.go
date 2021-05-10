package main

import (
    "fmt"
    "go-postgres/router"
    "log"
	"net/http"
	"os"
	"github.com/joho/godotenv"
)

func main() {
    r := router.Router()
    // fs := http.FileServer(http.Dir("build"))
	// http.Handle("/", fs)
	err := godotenv.Load(".env")

    if err != nil {
        log.Fatalf("Error loading .env file")
    }
	var serverPort string = os.Getenv("SERVER_PORT")
    fmt.Printf("Starting server on the port %s", serverPort)
    log.Fatal(http.ListenAndServe(":" + serverPort, r))
}