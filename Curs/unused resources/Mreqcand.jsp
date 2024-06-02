﻿@model CandList
@{
    ViewData["Title"] = "Кандидаты";
}


<h1>Список кандидатови</h1>

<table border="1" cellspacing="10">
    <tr><th>Имяи</th><th>Опыт</th><th>Описание</th><th>Ввозраст</th><th>Требуемая зарплата</th><th>Требуемая должность</th></tr>
    @foreach (Employee item in Model.list)
    {
        <tr>
            <td>@item.Name</td>
            <td>@item.expirience</td>
            <td>@item.aboutMe</td>
            <td>@item.age</td>
            <td>@item.requestedSalary</td>
            <td>@item.reuestedPost</td>
        </tr>

    }
</table>
<form method="post" asp-controller="Home" asp-action="backHome">
    <p><button type="submit">Назад</button></p>
    <input type="hidden" asp-for="companyId" value="@Model.companyId" />
</form>