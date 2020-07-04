package gmail

import (
	"api-send-mail/src/schedule"
	"net/http"

	"github.com/gin-gonic/gin"
)

// ForgotPassword with mail
func ForgotPassword(c *gin.Context) {
	schedule.MailTo = c.Param("email")
	c.JSON(http.StatusCreated, "ok")
}
