class Connection(object):
    def __init__(self, url, port):
        self.closed = None
        self.url = url
        self.port = port

    def connect(self):
        if not self.closed:
            return

        # Connect to url and port
        self.closed = False

    def getData(self):
        # Implement get data here
        return None

    def close(self):
        if self.closed:
            return None

        # Close the connection
        self.closed = True


class ConnectionPool(object):
    def __init__(self, url, port, size):
        self.url = url
        self.port = port
        self.size = size

        self.unused = [Connection(self.url, self.port) for i in range(size)]
        self.used = []

    def getConnection(self):
        if len(self.unused) > 0:
            conn = self.unused.pop()
            self.used.append(conn)
            return conn
        else:
            raise Exception('...')

    def releaseConnection(self, conn:Connection):
        if conn in self.used:
            if conn.closed:
                self.unused.append(Connection(self.url, self.port))
            else:
                self.unused.append(conn)
        else:
            raise Exception('...')
