<div id="header">
  <h2>FreeMarker Spring MVC Hello World</h2>
</div>
<div id="content">
  <table class="datatable">
    <tr>
      <th>Make</th>
      <th>Model</th>
    </tr>
    <#list model["events"] as event>
      <tr>
        <td>${event.make}</td>
        <td>${event.model}</td>
      </tr>
    </#list>
  </table>
</div>