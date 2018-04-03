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
          <form action="./events/event" method="post" >
             <div>Add new event</div>
             <table>
             <tr>
                                <td>Id:</td>
                                <td><input type="text" name="id" /></td>
                             </tr>
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
   </body>
</html>