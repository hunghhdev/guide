package schedule

import (
	"api-send-mail/src/utils/gmail"
	"log"
	"time"
)

var MailTo string

// SendMail schedule
func SendMail() {
	timer := time.NewTicker(time.Second * 10)
	for {
		select {
		case <-timer.C:
			go func() {
				if len(MailTo) > 0 {
					gmail.Send(MailTo, "forgot password", "click here http://google.com")
					log.Println("send mail ok")
					MailTo = ""
				}
			}()
		}
	}
}
