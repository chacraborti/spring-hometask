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
               <form action="events/book" method="post" commandName="bookForm">
               <tr>
                  <td>${event.id}</td>
                  <td>${event.name}</td>
                  <td>${event.basePrice}</td>
                  <td>${event.rating}</td>
                  <td><input type="submit" value="Book"/>
               </tr>
                </form>
               </#list>
            </tbody>
         </table>
      </div>
      </br>
      <div>
         <form action="events/event" method="post" commandName="eventForm">
            <div>Add new event</div>
            <table>
               <tr>
                  <td>Name:</td>
                  <td><input type="text" name="name" /></td>
               </tr>
               <tr>
                  <td>Price:</td>
                  <td><input type="text" name="basePrice" /></td>
               </tr>
               <tr>
                  <td>Event Rating</td>
                  <td>
                     <select name="rating">
                        <#list eventRatings as rating>
                        <option value="${rating}">${rating.name()}</option>
                        </#list>
                     </select>
                  </td>
               </tr>
               <tr>
                  <td><input type="submit" value="Submit" /></td>
               </tr>
            </table>
         </form>
      </div>
      </br>
      <div>
         <form method="post" action="events/uploadMultipleFile" enctype="multipart/form-data">
            File1 to upload: <input type="file" name="file"></br>
            File2 to upload: <input type="file" name="file"></br>
            <input type="submit" value="Upload"> Press here to upload the file!
         </form>
      </div>
   </body>
</html>