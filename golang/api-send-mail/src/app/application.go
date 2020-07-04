package app

import (
	"api-send-mail/src/controllers/gmail"
	"api-send-mail/src/schedule"

	"github.com/gin-gonic/gin"
)

var (
	router = gin.Default()
)

// StartApplication run app
func StartApplication() {
	go schedule.SendMail()
	router.GET("/forgot-password/:email", gmail.ForgotPassword)
	router.Run(":3000")
}
