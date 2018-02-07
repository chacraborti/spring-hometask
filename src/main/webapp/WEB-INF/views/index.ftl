<div id="header">
    <h2>FreeMarker Spring MVC Hello World</h2>
</div>
<div id="content">
        <legend>Events</legend>

    <#list model["events"] as event>
        <tr>
            <td>${event.name}</td>
            <td>${event.basePrice}</td>
        </tr>
    </#list>
    </table>
</div>