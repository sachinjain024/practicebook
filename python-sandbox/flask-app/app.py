import os
import sentry_sdk
from sentry_sdk.integrations.flask import FlaskIntegration
from flask import Flask

sentry_sdk.init(
    dsn=os.environ['PERSONAL_SENTRY_DSN'],
    integrations=[FlaskIntegration()]
)

app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello, World! 2'

@app.route('/debug-sentry')
def trigger_error():
    division_by_zero = 1 / 0
