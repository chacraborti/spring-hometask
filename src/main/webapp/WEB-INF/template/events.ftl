<html>
   <head>
      <title>Theater</title>
   <body>
   <h2>
            <a href="./">Theater</a>
            </h2>
         <div>
            <table>
               <thead>
                  <tr>
                     <th>Event #</th>
                     <th>Name</th>
                     <th>Price</th>
                     <th>Rating</th>
                  </tr>
               </thead>
               <tbody>
                  <#list events as event>
                  <tr>
                     <td>${event.id}</td>
                     <td>${event.name}</td>
                     <td>${event.basePrice}</td>
                     <td>${event.rating}</td>
                  </tr>
                  </#list>
               </tbody>
            </table>
         </div>
        <div>
            <form method="post" action="/event" enctype="multipart/form-data">
                <table>
                  <thead>
                      <tr>
                          <th>Create Event</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr><td><input type="file" name="file"></td></tr>
                      <tr><td><input type="file" name="file"></td></tr>
                      <tr><td><input type="file" name="file"></td></tr>
                      <tr><td><div align="center"><input type="submit" value="Upload"></div></td></tr>
                  </tbody>
                </table>
            </form>
          </div>
   </body>
</html>